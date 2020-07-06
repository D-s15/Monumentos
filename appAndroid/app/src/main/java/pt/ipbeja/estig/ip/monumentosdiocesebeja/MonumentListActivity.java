package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Update;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

public class MonumentListActivity extends AppCompatActivity {
    private MonumentAdapter monumentAdapter;
    private MonumentDao monumentDao;
    private Monument monument;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monument_list);

        ListView listViewMonument = findViewById(R.id.MonumentList);
        AppDatabase appDatabase = AppDatabase.getInstance(this);
        this.monumentDao = appDatabase.getMonumentDao();
        this.monumentAdapter = new MonumentAdapter(monumentDao.getAll(), this);
        listViewMonument.setAdapter(this.monumentAdapter);

        listViewMonument.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                Intent intent = new Intent(MonumentListActivity.this, MonumentDetailsActivity.class);
                intent.putExtra(MonumentDetailsActivity.KEY_ID, id);
                startActivity(intent);
            }
        });

        listViewMonument.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long id) {
                Intent intent = new Intent(MonumentListActivity.this, CustomTourActivity.class);
                intent.putExtra(CustomTourActivity.KEY_MON_ID, id);
                startActivity(intent);
                return true;
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