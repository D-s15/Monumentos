package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class TourGuideActivity extends AppCompatActivity {

    public static final String MON_ID = "id";

    private long id;
    private InterestPointDao interestPointDao;
    private InterestPointAdapter interestPointAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_guide);

        this.interestPointDao = AppDatabase.getInstance(this).getInterestPointDao();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            this.id = bundle.getLong(MON_ID, -1);
            if (this.id == -1) {
                finish();
            }
        }
        ListView interestPointList = findViewById(R.id.listViewInterestPoints);
        this.interestPointAdapter = new InterestPointAdapter(interestPointDao.getInterestPointsByMonumentId(this.id), this);
        interestPointList.setAdapter(this.interestPointAdapter);

        interestPointList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TourGuideActivity.this, InterestPointDetailsActivity.class);
                intent.putExtra(InterestPointDetailsActivity.INTEREST_POINT_ID, id);
                startActivity(intent);
            }
        });
    }

}
