package apps.rez.com.smartguru;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by mig on 25/09/2018.
 */

public class ProfileActivity extends MainActivity {

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
    }
}
