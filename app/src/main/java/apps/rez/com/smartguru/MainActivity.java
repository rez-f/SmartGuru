package apps.rez.com.smartguru;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;
    List dataList;
    NavigationView navigationView;
    SharedPrefManager sharedPrefManager;
    TextView userName, userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPrefManager = new SharedPrefManager(this);
        navigationView = findViewById(R.id.nav_view);
        drawer = findViewById(R.id.drawer_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);

        dataList = new ArrayList();

        setSupportActionBar(toolbar);
        getSupportActionBar().setElevation(0);
        setTitle("Daftar Kelas");

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        View headerView = navigationView.getHeaderView(0);
        userName = headerView.findViewById(R.id.tvUserName);
        userEmail = headerView.findViewById(R.id.tvUserEmail);

        userName.setText(sharedPrefManager.getSpNama());
        userEmail.setText(sharedPrefManager.getSpEmail());

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);
        navigationView.getMenu().getItem(1).setChecked(false);
        navigationView.getMenu().getItem(2).setChecked(false);
        navigationView.getMenu().getItem(3).setCheckable(false);
        navigationView.setCheckedItem(R.id.drawer_item_kelas);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {

        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.drawer_item_kelas) {
            startActivity(new Intent(this, HomeActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            overridePendingTransition(0, 0);
        } else if (id == R.id.drawer_item_siswa) {
            startActivity(new Intent(this, SiswaActivity.class));
            navigationView.getMenu().getItem(1);
            navigationView.setCheckedItem(R.id.drawer_item_siswa);
            overridePendingTransition(0, 0);
        } else if (id == R.id.drawer_item_profile) {
            startActivity(new Intent(this, ProfileActivity.class));
            navigationView.getMenu().getItem(2);
            navigationView.setCheckedItem(R.id.drawer_item_profile);
            overridePendingTransition(0, 0);
        } else if (id == R.id.drawer_item_logout){

            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Konfirmasi");
            builder.setMessage("Anda yakin ingin logout?");
            builder.setCancelable(true);
            builder.setNegativeButton("Tidak",null);
            builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(MainActivity.this, "Berhasil Logout", Toast.LENGTH_SHORT).show();
                    sharedPrefManager.clearSP();
                    sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_LOGGED_IN, false);
                    startActivity(new Intent(MainActivity.this, LoginActivity.class)
                            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                    finish();
                }
            });

            builder.show();

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}