package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class TourMonumentsActivity extends AppCompatActivity {
    public static final String KEY_ID = "id";
    private AppDatabase appDatabase;
    private Monument monument;
    private MonumentDao monumentDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_monuments);

        ImageView imageViewMonTour = findViewById(R.id.imageViewMonTour);

    this.appDatabase = AppDatabase.getInstance(this);



    }
}
