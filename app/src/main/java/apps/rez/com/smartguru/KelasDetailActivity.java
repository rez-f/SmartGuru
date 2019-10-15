package apps.rez.com.smartguru;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import apps.rez.com.smartguru.Models.Kelas;

public class KelasDetailActivity extends AppCompatActivity {

    public static final String EXTRAS_KELAS = "kelas";
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private Kelas kelas;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelas_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        bundle = new Bundle();

        kelas = getIntent().getParcelableExtra(EXTRAS_KELAS);

        if (kelas != null){
//            getSupportActionBar().setTitle("Kelas "+kelas.getKelas());
            getSupportActionBar().setTitle(getString(R.string.title_activity_kelas_detail, kelas.getKelas()));
            bundle.putInt("ID_MAPEL",kelas.getIdMapel());
            bundle.putString("ID_KELAS", String.valueOf(kelas.getId()));
            Log.d("DATA KELAS KelasDetail",String.valueOf(kelas.getId()));
            Log.d("DATA MAPEL KelasDetail",""+kelas.getIdMapel());
        }

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        KelasDetailFragment kelasDetailFragment = new KelasDetailFragment();
        kelasDetailFragment.setArguments(bundle);

        KelasSiswaFragment kelasSiswaFragment = new KelasSiswaFragment();
        kelasSiswaFragment.setArguments(bundle);

        KelasBerkasFragment kelasBerkasFragment = new KelasBerkasFragment();
        kelasBerkasFragment.setArguments(bundle);

        adapter.addFragment(kelasSiswaFragment, "Siswa");
        adapter.addFragment(kelasBerkasFragment, "Berkas");
        adapter.addFragment(kelasDetailFragment, "Detail");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
