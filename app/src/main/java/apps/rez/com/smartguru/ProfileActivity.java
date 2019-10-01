package apps.rez.com.smartguru;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * Created by mig on 25/09/2018.
 */

public class ProfileActivity extends MainActivity {

    SharedPrefManager sharedPrefManager;
    TextView namaGuru,NIPGuru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = LayoutInflater.from(this).inflate(R.layout.activity_profil, null, false);
        drawer.addView(view, 0);

        setTitle("Profil");

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(false);
        navigationView.getMenu().getItem(1).setChecked(false);
        navigationView.getMenu().getItem(2).setChecked(true);
        navigationView.setCheckedItem(R.id.drawer_item_profile);

        namaGuru = findViewById(R.id.tvNamaGuru);
        NIPGuru= findViewById(R.id.tvNIPGuru);

        sharedPrefManager = new SharedPrefManager(this);

//        namaGuru.setText(sharedPrefManager.getSpNama());
        namaGuru.setText(getResources().getString(R.string.data_key_value,"Nama",sharedPrefManager.getSpNama()));
        NIPGuru.setText(getResources().getString(R.string.data_key_value,"NIP",sharedPrefManager.getSpNip()));
    }
}
