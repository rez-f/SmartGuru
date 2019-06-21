package apps.rez.com.smartguru.Rest;

import apps.rez.com.smartguru.MainActivity;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by root on 2/3/17.
 */

public class ApiClient {

//    public static String BASE_URL = "http://192.168.100.14:8080/rest-api/wpu-rest-server/api/kelas/";
    public static String BASE_URL = "";
//    public static final String BASE_URL = "http://belajar-restserver.000webhostapp.com/index.php/kontak/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        /* applicationContext = MainActivity.getContextOfApplication();
        prefs = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        url = prefs.getString("BASE_SERVER",BASE_URL);
        */

        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
//                    .baseUrl("http://"+url+"/rest-codepolitan/index.php/kontak/")
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}