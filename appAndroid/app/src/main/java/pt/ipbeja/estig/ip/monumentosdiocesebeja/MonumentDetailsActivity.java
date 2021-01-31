package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class MonumentDetailsActivity extends AppCompatActivity {

    public static final String KEY_ID = "id";
    public static final String MON_ID = "MonId";

    private long id;
    private Monument monument;
    private InterestPointAdapter interestPointAdapter;
    private MonumentsViewModel monumentsviewModel;
    private InterestPointViewModel interestPointsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monument_details);

        TextView textViewMonumentName = findViewById(R.id.textViewMonumentName);
        ImageView imageViewMonumentImage = findViewById(R.id.imageViewMonumentImage);
        TextView textViewMorningSchedule = findViewById(R.id.textViewMorningSchedule);
        TextView textViewAfternoonSchedule = findViewById(R.id.textViewAfternoonSchedule);
        TextView textViewDescription = findViewById(R.id.textViewDescription);
        TextView textViewClosing = findViewById(R.id.textViewClosing);

        this.monumentsviewModel = new ViewModelProvider(this).get(MonumentsViewModel.class);
        this.interestPointsViewModel = new ViewModelProvider(this).get(InterestPointViewModel.class);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            this.id = bundle.getLong(KEY_ID, -1);
            if (this.id > 0) {
                this.monumentsviewModel.getMonument(this.id, this).observe(this, new Observer<Monument>() {
                    @Override
                    public void onChanged(Monument monument) {
                        MonumentDetailsActivity.this.monumentsviewModel.getMonument(id, MonumentDetailsActivity.this);
                        textViewMonumentName.setText(monument.getMonumentName());
                        Glide.with(MonumentDetailsActivity.this).load(monument.getMonumentImage()).apply(new RequestOptions().override(650, 650)).into(imageViewMonumentImage);
                        textViewMorningSchedule.setText(monument.getMorningSchedule());
                        textViewAfternoonSchedule.setText(monument.getAfternoonSchedule());
                        textViewDescription.setText(monument.getMonumentDescription());
                        textViewClosing.setText(monument.getClosing());
                    }
                });
            }
        }
        if (this.id == -1) {
            finish();
        }
        this.interestPointAdapter = new InterestPointAdapter(this);
        ListView interestPointList = findViewById(R.id.listViewInterestPoints);
        interestPointList.setAdapter(this.interestPointAdapter);

        interestPointList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MonumentDetailsActivity.this, InterestPointDetailsActivity.class);
                intent.putExtra(InterestPointDetailsActivity.INTEREST_POINT_ID, id);
                intent.putExtra("Monument", true);
                startActivity(intent);
            }
        });

    }

    public void onClickDetailsActivity(View view){
        Intent intent = new Intent(this, InterestPointDetailsActivity.class);
        intent.putExtra(MON_ID,monument.getId());
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.interestPointsViewModel.getInterestPointsByMonumentId(id, this).observe(this, new Observer<List<InterestPoint>>() {
            @Override
            public void onChanged(List<InterestPoint> interestPoints) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (InterestPoint interestPoint : interestPoints) {
                            InterestPointVisited interestPointVisited = interestPointsViewModel.getVisitedState(MonumentDetailsActivity.this, interestPoint.getId());
                            if (interestPointVisited != null) interestPoint.setSeen(interestPointVisited.isVisited());
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                MonumentDetailsActivity.this.interestPointAdapter.updateList(interestPoints);
                            }
                        });
                    }
                }).start();
            }
        });
    }
}
