package apps.rez.com.smartguru.Rest;

import java.util.List;

import apps.rez.com.smartguru.Model.DataItem;
import apps.rez.com.smartguru.Model.DataKelas;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("kelas")
    Call<DataKelas> getKelas();
}