package apps.rez.com.smartguru.Rest;

public class UtilsApi {
    public static String BASE_URL_API = "http://192.168.43.57/k13-restci/api/";

    // Mendeklarasikan Interface BaseApiService
    public static BaseApiService getAPIService() {
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
