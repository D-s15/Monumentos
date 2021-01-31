package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Monument> monumentList;
    private MonumentAdapter monumentAdapter;
    private MonumentsViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.viewModel = new ViewModelProvider(this).get(MonumentsViewModel.class);

        ListView listViewMonument = findViewById(R.id.MonumentList);
        this.monumentAdapter = new MonumentAdapter(this);
        listViewMonument.setAdapter(this.monumentAdapter);

        listViewMonument.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                Intent intent = new Intent(MainActivity.this, MonumentDetailsActivity.class);
                intent.putExtra(MonumentDetailsActivity.KEY_ID, id);
                startActivity(intent);
            }
        });

        this.viewModel.getMonumentsList().observe(this, new Observer<List<Monument>>() {
            @Override
            public void onChanged(List<Monument> monuments) {
                MainActivity.this.monumentList = monuments;
                MainActivity.this.monumentAdapter.updateList(monuments);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.viewModel.updateMonuments(this);
    }

    public void onClickSearchMonuments(View view) {
        EditText editTextSearchMonument = findViewById(R.id.editTextSearchMonument);
        String monumentSearch = editTextSearchMonument.getText().toString();
        this.viewModel.getSearchResults(monumentSearch, this).observe(this, new Observer<List<Monument>>() {
            @Override
            public void onChanged(List<Monument> monumentSearches) {
                monumentList = monumentSearches;
                monumentAdapter.updateList(monumentList);
            }
        });
    }
}