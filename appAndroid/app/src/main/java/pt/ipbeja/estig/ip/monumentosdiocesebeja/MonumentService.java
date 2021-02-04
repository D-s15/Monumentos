package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MonumentService {

  @GET("monument")
  Call<APIResponse<List<Monument>>> getMonuments();

  @GET("monument/{id}")
  Call<APIResponse<Monument>> getMonument(@Path("id") long id);

  @GET("point/{id}")
  Call<APIResponse<InterestPoint>> getInterestPointById(@Path("id") long id);

  @GET("monument/{monumentId}/point")
  Call<APIResponse<List<InterestPoint>>> getInterestPointsByMonumentId(@Path("monumentId") long id);
}
