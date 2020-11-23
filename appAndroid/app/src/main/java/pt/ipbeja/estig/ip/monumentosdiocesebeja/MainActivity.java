package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private MonumentAdapter monumentAdapter;
    private MonumentDao monumentDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listViewMonument = findViewById(R.id.MonumentList);
        AppDatabase appDatabase = AppDatabase.getInstance(this);
        this.monumentDao = appDatabase.getMonumentDao();
        this.monumentAdapter = new MonumentAdapter(monumentDao.getAll(), this);
        listViewMonument.setAdapter(this.monumentAdapter);

        listViewMonument.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                Intent intent = new Intent(MainActivity.this, MonumentDetailsActivity.class);
                intent.putExtra(MonumentDetailsActivity.KEY_ID, id);
                startActivity(intent);
            }
        });
    }

    public void onClickSearchMonuments(View view) {
        EditText editTextSearchMonument = findViewById(R.id.editTextSearchMonument);
        String monumentSearch = editTextSearchMonument.getText().toString();
        this.monumentDao.searchMonuments(monumentSearch);
        this.monumentAdapter.updateList(this.monumentDao.searchMonuments(monumentSearch));
    }
}