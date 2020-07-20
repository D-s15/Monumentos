package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class TourMapActivity extends AppCompatActivity {

    public static final String KEY_MON_ID = "id";
    private long id;
    private Monument monument;
    private MonumentDao monumentDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_map);

        final ImageView imageViewMap = findViewById(R.id.imageViewMap);

        this.monumentDao = AppDatabase.getInstance(this).getMonumentDao();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            this.id = bundle.getLong(KEY_MON_ID, -1);
            if (this.id == -1) {
                finish();
            }

            this.monument = this.monumentDao.getById(this.id);
            Log.i("map", this.monument.getMonumentMap());
            Glide.with(this).load(this.monument.getMonumentMap()).apply(new RequestOptions().override(1000, 1000)).into(imageViewMap);
        }
    }
}
