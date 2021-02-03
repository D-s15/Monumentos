package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MonumentDataSource {

    private static final String ENDPOINT = "http://localhost:8000/api/";

    private static final Retrofit retrofit = new Retrofit.Builder().baseUrl(ENDPOINT).
            addConverterFactory(GsonConverterFactory.create()).build();

    private static MonumentService monumentService;

    public static MonumentService getMonumentService(){
        if (monumentService == null){
            monumentService = retrofit.create(MonumentService.class);
        }
        return monumentService;
    }
}
