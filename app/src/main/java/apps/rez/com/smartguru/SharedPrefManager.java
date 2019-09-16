package apps.rez.com.smartguru;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {
    public static final String SP_SMARTGURU_APP = "spSmartGuruApp";
    public static final String SP_ID = "spID";
    public static final String SP_LOGGED_IN = "spLoggedIn";

    SharedPreferences sp;
    SharedPreferences.Editor spEditor;

    public SharedPrefManager(Context context) {
        sp = context.getSharedPreferences(SP_SMARTGURU_APP, Context.MODE_PRIVATE);
        spEditor = sp.edit();
    }

    public void saveSPString(String keySP, String value) {
        spEditor.putString(keySP, value);
        spEditor.commit();
    }

    public void saveSPInt(String keySP, int value) {
        spEditor.putInt(keySP, value);
        spEditor.commit();
    }

    public void saveSPBoolean(String keySP, boolean value) {
        spEditor.putBoolean(keySP, value);
        spEditor.commit();
    }

    public int getSPid() {
        return sp.getInt(SP_ID, 1);
    }

    public Boolean getSPLoggedIn() {
        return sp.getBoolean(SP_LOGGED_IN, false);
    }
}
