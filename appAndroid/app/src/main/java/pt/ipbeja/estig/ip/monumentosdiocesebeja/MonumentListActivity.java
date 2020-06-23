package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MonumentListActivity extends AppCompatActivity {
    private MonumentAdapter monumentAdapter;
    private MonumentDao monumentDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monument_list);

        ListView listViewMonument = findViewById(R.id.MonumentList);
        AppDatabase appDatabase = AppDatabase.getInstance(this);
        this.monumentDao = appDatabase.getMonumentDao();
        this.monumentAdapter = new MonumentAdapter(monumentDao.getAll(), this);
        listViewMonument.setAdapter(this.monumentAdapter);

        listViewMonument.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MonumentListActivity.this, MonumentDetailsActivity.class);
                intent.putExtra(MonumentDetailsActivity.KEY_ID, id);
                startActivity(intent);
            }
        });
    }
}