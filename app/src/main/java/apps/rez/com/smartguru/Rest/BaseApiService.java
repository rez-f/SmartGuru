package apps.rez.com.smartguru.Rest;

import java.util.List;

import apps.rez.com.smartguru.Models.DataKelas;
import apps.rez.com.smartguru.Models.NamaSiswa;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface BaseApiService {
    @FormUrlEncoded
    @POST("auth")
    Call<ResponseBody> authLogin(@Field("username") String username,
                                 @Field("password") String password);

    @GET("kelas/id")
    Call<DataKelas> getKelas(@Query("id") int id);

    @GET("siswa/id")
    Call<NamaSiswa> getSiswa(@Query("id") int id);
}