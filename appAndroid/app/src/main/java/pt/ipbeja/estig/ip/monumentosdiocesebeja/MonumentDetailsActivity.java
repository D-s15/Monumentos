package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class MonumentDetailsActivity extends AppCompatActivity {

    public static final String KEY_ID = "id";

    private long id;
    private Monument monument;
    private MonumentDao monumentDao;
    private InterestPointDao interestPointDao;
    private InterestPointAdapter interestPointAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monument_details);

        TextView textViewMonumentName = findViewById(R.id.textViewMonumentName);
        ImageView imageViewMonumentImage = findViewById(R.id.imageViewMonumentImage);
        TextView textViewMorningSchedule = findViewById(R.id.textViewMorningSchedule);
        TextView textViewAfternoonSchedule = findViewById(R.id.textViewAfternoonSchedule);
        TextView textViewDescription = findViewById(R.id.textViewDescription);

        this.monumentDao = AppDatabase.getInstance(this).getMonumentDao();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            this.id = bundle.getLong(KEY_ID, -1);
            if (this.id == -1) {
                finish();
            }
        }

            this.monument = this.monumentDao.getById(this.id);
            textViewMonumentName.setText(this.monument.getMonumentName());
            Glide.with(this).load(this.monument.getMonumentImage()).apply(new RequestOptions().override(650, 650)).into(imageViewMonumentImage);
            textViewMorningSchedule.setText("horário de manhã: " + this.monument.getMorningSchedule());
            textViewAfternoonSchedule.setText("horário de tarde: " + this.monument.getAfternoonSchedule());
            textViewDescription.setText(this.monument.getMonumentDescription());

        ListView interestPointList = findViewById(R.id.listViewInterestPoints);
        this.interestPointDao = AppDatabase.getInstance(this).getInterestPointDao();
        this.interestPointAdapter = new InterestPointAdapter(interestPointDao.getInterestPointsByMonumentId(monument.getId()),this);
        interestPointList.setAdapter(this.interestPointAdapter);

        interestPointList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MonumentDetailsActivity.this, InterestPointDetailsActivity.class);
                intent.putExtra(InterestPointDetailsActivity.INTEREST_POINT_ID, id);
                startActivity(intent);
            }
        });
    }

    public void onClickCustomTour(View view){
    }

    public void onClickGuidedTour(View view){
    }
}
