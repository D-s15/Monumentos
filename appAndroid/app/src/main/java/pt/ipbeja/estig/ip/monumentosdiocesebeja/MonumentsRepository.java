package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MonumentsRepository {

    private MonumentDao monumentDao;
    private InterestPointDao interestPointDao;
    private MonumentService monumentService = MonumentDataSource.getMonumentService();
    private MutableLiveData<List<Monument>> monumentsListLiveData = new MutableLiveData<>();
    private MutableLiveData<List<InterestPoint>> interestPointsListLiveData = new MutableLiveData<>();
    private MutableLiveData<InterestPoint> interestPointLiveData = new MutableLiveData<>();

    private MonumentDao getMonumentDao(final Context context){
        if (this.monumentDao == null){
            monumentDao = AppDatabase.getInstance(context.getApplicationContext()).getMonumentDao();
        }
        return monumentDao;
    }

    private InterestPointDao getInterestPointDao(final Context context){
        if (this.interestPointDao == null){
            interestPointDao = AppDatabase.getInstance(context.getApplicationContext()).getInterestPointDao();
        }
        return interestPointDao;
    }

    public LiveData<List<Monument>> getMonumentList(){
        return monumentsListLiveData;
    }

    public void updateMonuments(final Context context){
        Call<APIResponse<List<Monument>>> call = monumentService.getMonuments();
        call.enqueue(new Callback<APIResponse<List<Monument>>>() {
            @Override
            public void onResponse(Call<APIResponse<List<Monument>>> call, Response<APIResponse<List<Monument>>> response) {
                if (response.isSuccessful()){
                    final List<Monument> monumentList = response.body().getData();
                    if (monumentList != null) {
                        monumentsListLiveData.postValue(monumentList);
                    }
                }
            }

            @Override
            public void onFailure(Call<APIResponse<List<Monument>>> call, Throwable t) {
                Log.e("Main Activity", "An error occurred");
            }
        });
    }

    public LiveData<Monument> getMonument(long id, final Context context){
        MutableLiveData<Monument> monumentLiveData = new MutableLiveData<>();
        Call<APIResponse<Monument>> call = monumentService.getMonument(id);
        call.enqueue(new Callback<APIResponse<Monument>>() {
            @Override
            public void onResponse(Call<APIResponse<Monument>> call, Response<APIResponse<Monument>> response) {
                if (response.isSuccessful()) {
                    final Monument monument = response.body().getData();
                    if (monument != null){
                        monumentLiveData.postValue(monument);
                    }
                }
            }

            @Override
            public void onFailure(Call<APIResponse<Monument>> call, Throwable t) {
                Log.e("Details Activity", "An error occurred");
            }
        });
        return monumentLiveData;
    }

    public LiveData<InterestPoint> getInterestPoint(long id, final Context context){

        Call<APIResponse<InterestPoint>> call = monumentService.getInterestPointById(id);
        call.enqueue(new Callback<APIResponse<InterestPoint>>() {
            @Override
            public void onResponse(Call<APIResponse<InterestPoint>> call, Response<APIResponse<InterestPoint>> response) {
                if (response.isSuccessful()){
                    final InterestPoint interestPoint = response.body().getData();
                    if (interestPoint != null) {
                        interestPointLiveData.postValue(interestPoint);
                    }
                }
            }

            @Override
            public void onFailure(Call<APIResponse<InterestPoint>> call, Throwable t) {
            Log.e("Details Activity", "an error occurred");
            }
        });
        return interestPointLiveData;
    }

    public LiveData<List<InterestPoint>> getInterestPointsByMonumentId(final long monumentId, final Context context){
        MutableLiveData<List<InterestPoint>> interestPointsList = new MutableLiveData<>();
        Call<APIResponse<List<InterestPoint>>> call = monumentService.getInterestPointsByMonumentId(monumentId);
        call.enqueue(new Callback<APIResponse<List<InterestPoint>>>() {
            @Override
            public void onResponse(Call<APIResponse<List<InterestPoint>>> call, Response<APIResponse<List<InterestPoint>>> response) {
                if (response.isSuccessful()) {
                    final List<InterestPoint> interestPointsByMonumentIdList = response.body().getData();
                    interestPointsList.postValue(interestPointsByMonumentIdList);
                }
            }

            @Override
            public void onFailure(Call<APIResponse<List<InterestPoint>>> call, Throwable t) {
            Log.e("Details Activity", "an error occurred");
            }
        });
        return interestPointsList;
    }

    public void changeSeen(Context context, long id, boolean isSeen){
        new Thread(new Runnable() {
            @Override
            public void run() {
                interestPointDao.update(new InterestPointVisited(id, isSeen));
            }
        }).start();
    }

    public InterestPointVisited getInterestPointVisitedState(Context context, long interestPointId) {
        return this.getInterestPointDao(context).getById(interestPointId);
    }

    public LiveData<List<Monument>> monumentsSearchList(String name, Context context){
        final MutableLiveData<List<Monument>> searchList = new MutableLiveData<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
               searchList.postValue(monumentDao.getSearchResults(name));
            }
        }).start();

        return searchList;
    }

}

