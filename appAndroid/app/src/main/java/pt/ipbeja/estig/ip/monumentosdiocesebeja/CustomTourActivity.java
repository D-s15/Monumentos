package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class CustomTourActivity extends AppCompatActivity {

    public static final String KEY_ID = "id";

    private long id;
    private Monument monument;
    private MonumentDao monumentDao;
    private TourDao tourDao;
    private TourAdapter tourAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_tour);
        ListView listViewTours = findViewById(R.id.listViewGuidedTour);
        this.tourDao = AppDatabase.getInstance(this).getVisitaDao();
        this.tourAdapter = new TourAdapter(this, tourDao.getAll());
        listViewTours.setAdapter(tourAdapter);

    }
}
