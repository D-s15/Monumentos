package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class TourGuideActivity extends AppCompatActivity {

    private Monument monument;
    private TourDao tourDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_guide);

    this.tourDao = AppDatabase.getInstance(this).getTourDao();


    }
}
