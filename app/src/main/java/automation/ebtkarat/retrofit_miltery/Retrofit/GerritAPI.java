package automation.ebtkarat.retrofit_miltery.Retrofit;

import java.util.List;

import automation.ebtkarat.retrofit_miltery.Data.change;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Antnna on 05-Feb-19.
 */

public interface GerritAPI {
    @GET("change/")
    Call<List<change>>loadChanges(@Query("q")String status);
}
