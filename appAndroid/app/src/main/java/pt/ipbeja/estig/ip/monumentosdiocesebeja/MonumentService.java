package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MonumentService {

  @GET("monument")
  Call<List<Monument>> getMonuments();

  @GET("monument/{id}")
  Call<Monument> getMonument(@Path("id") long id);

  @GET("interestPoints/{id}")
  Call<InterestPoint> getInterestPointById(@Path("id") long id);

  @GET("interestPoints/")
  Call<List<InterestPoint>> getInterestPointsByMonumentId(@Query("monumentId") long id);
}
