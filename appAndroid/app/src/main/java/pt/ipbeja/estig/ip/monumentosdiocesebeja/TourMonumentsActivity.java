package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class TourMonumentsActivity extends AppCompatActivity {
    public static final String KEY_ID = "id";
    private MonumentReferenceDao monumentReferenceDao;
    private MonumentReference monumentReference;
    private AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_monuments);

    this.appDatabase = AppDatabase.getInstance(this);
    this.monumentReferenceDao= appDatabase.getMonumentReferenceDao();

    }
}
