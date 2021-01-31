package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MonumentsViewModel extends ViewModel {

    private MonumentsRepository repository = new MonumentsRepository();

    public LiveData<List<Monument>> getMonumentsList(){
        return this.repository.getMonumentList();
    }

    public void updateMonuments(Context context){
        this.repository.updateMonuments(context);
    }

    public LiveData<Monument> getMonument(long id, Context context){
        return this.repository.getMonument(id, context);
    }

    public LiveData<List<Monument>> getSearchResults(String name, Context context) {
        return this.repository.monumentsSearchList(name, context);
    }
}