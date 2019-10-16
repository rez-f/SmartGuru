package apps.rez.com.smartguru.Rest;

public class UtilsApi {
    public static String BASE_URL_API = "http://192.168.100.14/k13-RestCI/api/";

    // Mendeklarasikan Interface BaseApiService
    public static BaseApiService getAPIService() {
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
