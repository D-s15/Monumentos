package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class InterestPointViewModel extends ViewModel {

    public MonumentsRepository repository = new MonumentsRepository();

    public LiveData<InterestPoint> getInterestPoint(long id, Context context){
        return this.repository.getInterestPoint(id, context);
    }

    public LiveData<List<InterestPoint>> getInterestPointsByMonumentId(long monumentId, Context context){
        return this.repository.getInterestPointsByMonumentId(monumentId, context);
    }

    public void changeSeen(Context context, long id, boolean isSeen){
        this.repository.changeSeen(context, id, isSeen);
    }

    public InterestPointVisited getVisitedState(Context context, long interestPointId) {
        return this.repository.getInterestPointVisitedState(context, interestPointId);
    }
}
