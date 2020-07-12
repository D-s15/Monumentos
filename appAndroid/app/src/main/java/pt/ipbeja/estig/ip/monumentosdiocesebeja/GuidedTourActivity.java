package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        tourList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                Intent intent = new Intent(GuidedTourActivity.this, TourMonumentsActivity.class);
                intent.putExtra(TourMonumentsActivity.KEY_ID, id);
                startActivity(intent);
            }
        });

    }
}
