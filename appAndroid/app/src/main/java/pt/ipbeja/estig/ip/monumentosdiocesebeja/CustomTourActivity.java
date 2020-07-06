package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class CustomTourActivity extends AppCompatActivity {

    public static final String KEY_MON_ID = "id";
    private long id;
    private Monument monument;
    private MonumentDao monumentDao;
    private InterestPoint interestPoint;
    private InterestPointDao interestPointDao;
    private InterestPointAdapter interestPointAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_tour);



            this.monumentDao = AppDatabase.getInstance(this).getMonumentDao();
            Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            this.id = bundle.getLong(KEY_MON_ID, -1);
            if (this.id == -1) {
                finish();
            }
        }


            this.monument = monumentDao.getById(this.id);
            ListView interestPointList = findViewById(R.id.listViewCustomTour);
            this.interestPointDao = AppDatabase.getInstance(this).getInterestPointDao();
            this.interestPointAdapter = new InterestPointAdapter(interestPointDao.getInterestPointsByMonumentId(this.monument.getId()), this);
            interestPointList.setAdapter(this.interestPointAdapter);
        }
    }
