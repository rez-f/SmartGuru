package apps.rez.com.smartguru;

import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import apps.rez.com.smartguru.Adapter.SiswaAdapter;
import apps.rez.com.smartguru.Models.NamaSiswa;
import apps.rez.com.smartguru.Rest.BaseApiService;
import apps.rez.com.smartguru.Rest.UtilsApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mig on 25/09/2018.
 */

public class SiswaActivity extends MainActivity {

    BaseApiService mApiService;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private SwipeRefreshLayout swipeRefreshLayout;

    private StringBuilder textUrl;
    private boolean fileServerExist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = LayoutInflater.from(this).inflate(R.layout.activity_siswa, null, false);
        drawer.addView(view, 0);

        setTitle("Daftar Siswa");

        mRecyclerView = findViewById(R.id.recyclerSiswa);
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setLayoutParams(new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT,ConstraintLayout.LayoutParams.MATCH_PARENT));
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 2000);
            }
        });

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(false);
        navigationView.getMenu().getItem(1).setChecked(true);
        navigationView.getMenu().getItem(2).setChecked(false);
        navigationView.setCheckedItem(R.id.drawer_item_siswa);

        swipeRefreshLayout.setRefreshing(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(new SiswaAdapter(dataList));

        getServerIpFromFile();

        if(fileServerExist){
            UtilsApi.BASE_URL_API = "" + textUrl;
        }
        mApiService = UtilsApi.getAPIService(); // meng-init yang ada di package apihelper

        getSiswaList();
    }

    public void getSiswaList() {
        final List list = new ArrayList();

        mApiService.getSiswa(sharedPrefManager.getSPid()).enqueue(new Callback<NamaSiswa>() {
            @Override
            public void onResponse(Call<NamaSiswa> call, Response<NamaSiswa> response) {
                NamaSiswa dataSiswaList = response.body();
                if (response.body() != null){
                    for (int i = 0; i < response.body().getData().size(); i++) {
                        list.add(response.body());
                    }
                    mAdapter = new SiswaAdapter(list);
                    mRecyclerView.setAdapter(mAdapter);
                    swipeRefreshLayout.setEnabled(false);
                }else{
                    Toast.makeText(SiswaActivity.this, "Tidak ada respon server", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<NamaSiswa> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
                Toast.makeText(SiswaActivity.this, "Request Gagal", Toast.LENGTH_LONG).show();
                Toast.makeText(SiswaActivity.this, t.toString(), Toast.LENGTH_LONG).show();
            }
        });
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
