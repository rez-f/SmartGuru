package apps.rez.com.smartguru;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import apps.rez.com.smartguru.Model.Siswa;

public class SiswaDetailActivity extends AppCompatActivity {

    public static final String EXTRAS_SISWA = "siswa";
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siswa_detail);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        bundle = new Bundle();

        Siswa siswa = getIntent().getParcelableExtra(EXTRAS_SISWA);

        if (siswa != null){
            getSupportActionBar().setTitle(siswa.getNama());
            bundle.putString("nama",siswa.getNama());
        }

        FragmentManager mFragmentManager = getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();

        SiswaDetailFragment mSiswaDetailFragment = new SiswaDetailFragment();
        mSiswaDetailFragment.setArguments(bundle);

        mFragmentTransaction.add(R.id.frame_container, mSiswaDetailFragment, SiswaDetailFragment.class.getSimpleName());
        mFragmentTransaction.commit();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
