package apps.rez.com.smartguru;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import apps.rez.com.smartguru.Model.Siswa;

public class SiswaDetailActivity extends AppCompatActivity {

    public static final String EXTRAS_SISWA = "siswa";
    private Bundle bundle;
    private Siswa siswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siswa_detail);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        bundle = new Bundle();
        siswa = getIntent().getParcelableExtra(EXTRAS_SISWA);

        if (siswa != null){
            getSupportActionBar().setTitle(siswa.getNama());

            bundle.putString("NAMA_SISWA", siswa.getNama());
            bundle.putString("NIS_SISWA", siswa.getNis());
            bundle.putString("NISN_SISWA", siswa.getNisn());
            bundle.putString("TEMPAT_LAHIR_SISWA", siswa.getTempatLahir());
            bundle.putString("TANGGAL_LAHIR_SISWA", siswa.getTanggalLahir());
            bundle.putString("JENIS_KELAMIN_SISWA", siswa.getJenisKelamin());
            bundle.putString("AGAMA_SISWA", siswa.getAgama());
            bundle.putString("ALAMAT_SISWA", siswa.getAlamat());
            bundle.putString("NAMA_AYAH_SISWA", siswa.getNamaAyah());
            bundle.putString("PEKERJAAN_AYAH_SISWA", siswa.getPekerjaanAyah());
            bundle.putString("NAMA_IBU_SISWA", siswa.getNamaIbu());
            bundle.putString("PEKERJAAN_IBU_SISWA", siswa.getPekerjaanIbu());
            bundle.putString("ALAMAT_AYAH_SISWA", siswa.getAlamatAyah());
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
