package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class InterestPointDetailsActivity extends AppCompatActivity {
    public static final String INTEREST_POINT_ID = "id";

    private InterestPoint interestPoint;
    private InterestPointDao interestPointDao;
    private long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest_point_details);

        TextView interestPointName = findViewById(R.id.textViewInterestPointName);
        ImageView interestPointImage = findViewById(R.id.imageViewInterestPointImage);
        TextView interestPointDescription = findViewById(R.id.textViewInterestPointDescription);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            this.id = bundle.getLong(INTEREST_POINT_ID, -1);
            if (this.id == -1) {
                finish();
            }
        }

        this.interestPointDao = AppDatabase.getInstance(this).getInterestPointDao();
        this.interestPoint = interestPointDao.getById(this.id);
        interestPointName.setText(this.interestPoint.getInterestPointName());
        Glide.with(this).load(this.interestPoint.getInterestPointImage()).apply(new RequestOptions().override(600, 600)).into(interestPointImage);
        interestPointDescription.setText("Descrição: " + this.interestPoint.getInterestPointDesctiption());
    }
}
