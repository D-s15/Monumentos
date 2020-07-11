package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class GuidedTourActivity extends AppCompatActivity {
    private TourDao tourDao;
    private Tour tour;
    private AppDatabase appDatabase;
    private TourAdapter tourAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guided_tour);

        ListView tourList = findViewById(R.id.listViewTours);
        this.appDatabase = AppDatabase.getInstance(this);
        this.tourDao = appDatabase.getTourDao();
        this.tourAdapter = new TourAdapter(this, this.tourDao.getAll());
        tourList.setAdapter(this.tourAdapter);


    }
}
