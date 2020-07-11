package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickLoginActivity(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void onClickGuidedTour(View view) {
    Intent intent = new Intent(this, GuidedTourActivity.class);
    startActivity(intent);
    }

    public void onClickMonuments(View view) {
    Intent intent = new Intent(this, MonumentListActivity.class);
    startActivity(intent);
    }

}