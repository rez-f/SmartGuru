package apps.rez.com.smartguru;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import apps.rez.com.smartguru.Adapter.KelasAdapter;
import apps.rez.com.smartguru.Models.DataKelas;
import apps.rez.com.smartguru.Models.Kelas;
import apps.rez.com.smartguru.Models.KelasItem;
import apps.rez.com.smartguru.Rest.BaseApiService;
import apps.rez.com.smartguru.Rest.UtilsApi;
import apps.rez.com.smartguru.listener.ItemClickSupport;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mig on 25/09/2018.
 */

public class HomeActivity extends MainActivity {

    BaseApiService mApiService;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private SwipeRefreshLayout swipeRefreshLayout;
    private CardView cardView;
    private StringBuilder textUrl;

    SharedPrefManager sharedPrefManager;
    private boolean fileServerExist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = LayoutInflater.from(this).inflate(R.layout.activity_home, null, false);
        drawer.addView(view, 0);

        sharedPrefManager = new SharedPrefManager(this);

        /*
        cardView = (CardView) findViewById(R.id.cardViewTambah);
        cardView.setVisibility(View.INVISIBLE);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TambahKelasModalFragment tambahKelas = new TambahKelasModalFragment();
                FragmentManager fm = getSupportFragmentManager();
                tambahKelas.show(fm, "Fragment Tambah Kelas");
            }
        });
        */

        mRecyclerView = findViewById(R.id.recyclerKelas);
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setLayoutParams(new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.MATCH_PARENT));
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 2000);
            }
        });
        swipeRefreshLayout.setRefreshing(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(new KelasAdapter(dataList));

        getServerIpFromFile();

        if (fileServerExist) {
            UtilsApi.BASE_URL_API = "" + textUrl;
        }

        if(sharedPrefManager.getSPid() != 0){
            mApiService = UtilsApi.getAPIService(); // meng-init yang ada di package apihelper
            getKelasList();
        }else{
            swipeRefreshLayout.setEnabled(false);
            Toast.makeText(this, "Tidak ada data untuk ditampilkan", Toast.LENGTH_SHORT).show();
        }

    }

    private void getKelasList() {
        final List list = new ArrayList();

        mApiService.getKelas(sharedPrefManager.getSPid()).enqueue(new Callback<DataKelas>() {
            @Override
            public void onResponse(Call<DataKelas> call, final Response<DataKelas> response) {
                final DataKelas KelasList = response.body();

                if (response.body() != null) {
                    for (int i = 0; i < response.body().getData().size(); i++) {
                        list.add(response.body());
                    }
                    Log.d("Retrofit Get", "Jumlah data Kelas : " + String.valueOf(response.body().toString()));
                    mAdapter = new KelasAdapter(list);
                    mRecyclerView.setAdapter(mAdapter);
//                    cardView.setVisibility(View.VISIBLE);
                    swipeRefreshLayout.setEnabled(false);

                    ItemClickSupport.addTo(mRecyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                        @Override
                        public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                            tampilKelasDetail(response.body().getData().get(position));
                        }
                    });
                } else {
                    Toast.makeText(HomeActivity.this, "Tidak ada respon server", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DataKelas> call, Throwable t) {
                Toast.makeText(HomeActivity.this, "Request Gagal", Toast.LENGTH_LONG).show();
                Log.e("Retrofit Get", t.toString());
                Toast.makeText(HomeActivity.this, t.toString(), Toast.LENGTH_LONG).show();
                swipeRefreshLayout.setEnabled(false);
            }
        });
    }
    private void tampilKelasDetail(KelasItem dataKelas) {
        Kelas kelas = new Kelas();

        kelas.setId(Integer.parseInt(dataKelas.getIdKelas()));
        kelas.setKelas(dataKelas.getNamaKelas());
        kelas.setMataPelajaran(dataKelas.getMATAPELAJARAN());

        Intent intent = new Intent(HomeActivity.this, KelasDetailActivity.class);
        intent.putExtra(KelasDetailActivity.EXTRAS_KELAS, kelas);
        startActivity(intent);
    }

    private void getServerIpFromFile() {
        File sdcard = Environment.getExternalStorageDirectory();

        //Get the text file
        File file = new File(sdcard, "server.txt");

        textUrl = new StringBuilder();

        //Read text from file
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                textUrl.append(line);
            }
            fileServerExist = true;
            br.close();
        } catch (IOException e) {
            //You'll need to add proper error handling here
            fileServerExist = false;
        }
    }
}
