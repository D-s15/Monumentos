package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class InterestPointDetailsActivity extends AppCompatActivity {
    public static final String INTEREST_POINT_ID = "id";

    private InterestPoint interestPoint;
    private InterestPointViewModel viewModel;
    private long id;
    private Button toggleButton;
    private TextView interestPointName;
    private TextView interestPointDescription;
    private ImageView interestPointImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest_point_details);

        this.viewModel = new ViewModelProvider(this).get(InterestPointViewModel.class);

        this.interestPointName = findViewById(R.id.textViewInterestPointName);
        this.interestPointImage = findViewById(R.id.imageViewfavourite);
        this.interestPointDescription = findViewById(R.id.textViewInterestPointDescription);
        ImageButton imageButtonNarration = findViewById(R.id.imageButtonNarration);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            this.id = bundle.getLong(INTEREST_POINT_ID, -1);
            if (this.id > 0) {
               this.viewModel.getInterestPoint(this.id, this).observe(this, new Observer<InterestPoint>() {
                    @Override
                    public void onChanged(final InterestPoint interestPoint) {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                InterestPointVisited interestPointVisited = viewModel.getVisitedState(InterestPointDetailsActivity.this, interestPoint.getId());
                                if (interestPointVisited != null) interestPoint.setSeen(interestPointVisited.isVisited());
                                InterestPointDetailsActivity.this.interestPoint = interestPoint;
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        updateUI();
                                    }
                                });
                            }
                        }).start();
                    }
                });
            }
        }
            if (this.id == -1) {
                finish();
            }

        interestPointDescription.setMovementMethod(new ScrollingMovementMethod());

        Glide.with(this).load(R.drawable.ic_volume_up_24px).into(imageButtonNarration);

        toggleButton = findViewById(R.id.buttonToggleSeen);
        toggleButton.setText("marcar ponto de interesse como visto");
    }

    public void onClickToggleSeen(View view){
        //Log.e("seen", String.valueOf(interestPoint.isSeen()));
        this.interestPoint.setSeen(!this.interestPoint.isSeen());
        // TODO: persistir o valor do isSeen para este interestPoint (ligar o booleano ao id do interestPoint na BD)
        this.viewModel.changeSeen(this, this.interestPoint.getId(), this.interestPoint.isSeen());
        this.toggleSeenButtonText(this.interestPoint.isSeen());
    }

    private void updateUI() {
        if (this.interestPoint != null) this.toggleSeenButtonText(this.interestPoint.isSeen());
        interestPointName.setText(interestPoint.getInterestPointName());
        Glide.with(InterestPointDetailsActivity.this).load(interestPoint.getInterestPointImage()).apply(new RequestOptions().override(600, 600)).into(interestPointImage);
        interestPointDescription.setText("Descrição: " + interestPoint.getInterestPointDescription());
    }

    private void toggleSeenButtonText(boolean isSeen) {
        this.toggleButton.setText(isSeen ? "marcar ponto de interesse como não visto" : "marcar ponto de interesse como visto");
    }

}