package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class CustomTourActivity extends AppCompatActivity {

    public static final String KEY_ID = "id";

    private long id;
    private Monument monument;
    private MonumentDao monumentDao;
    private VisitaDao visitaDao;
    private VisitaAdapter visitaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_tour);
        ListView listViewTours = findViewById(R.id.listViewGuidedTour);
        this.visitaDao = AppDatabase.getInstance(this).getVisitaDao();
        this.visitaAdapter = new VisitaAdapter(this, visitaDao.getAll());
        listViewTours.setAdapter(visitaAdapter);

    }
}
