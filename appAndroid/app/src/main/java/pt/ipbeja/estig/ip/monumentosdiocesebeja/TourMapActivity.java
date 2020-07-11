package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class TourMapActivity extends AppCompatActivity {

    public static final String KEY_MON_ID = "id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_map);

        ImageView imageViewMap = findViewById(R.id.imageViewMap);

        Glide.with(this).load(R.drawable.castelo_beja_planta).apply(new RequestOptions().override(1000, 1000)).into(imageViewMap);
    }
}
