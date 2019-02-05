package automation.ebtkarat.retrofit_miltery.Retrofit;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import automation.ebtkarat.retrofit_miltery.Data.change;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Antnna on 05-Feb-19.
 */

public class Controller implements Callback<List<change>> {
    static  final String BASE_URL="https://git.eclipse.org/r/";
    public  void Start(){
        Gson gson=new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        GerritAPI gerritAPI=retrofit.create(GerritAPI.class);
        Call<List<change>>call=gerritAPI.loadChanges("status:open");
        call.enqueue(this);

    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onResponse(Call<List<change>> call, Response<List<change>> response) {
        if(response.isSuccessful()){
            List<change>changeList=response.body();
            changeList.forEach(change -> System.out.print(change.getSubject()));
        }else{
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<List<change>> call, Throwable t) {
            t.printStackTrace();
    }
}
