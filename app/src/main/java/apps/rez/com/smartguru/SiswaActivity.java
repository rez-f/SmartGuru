package apps.rez.com.smartguru;

import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import apps.rez.com.smartguru.Adapter.SiswaAdapter;
import apps.rez.com.smartguru.Model.DataSiswa;
import apps.rez.com.smartguru.Rest.ApiClient;
import apps.rez.com.smartguru.Rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mig on 25/09/2018.
 */

public class SiswaActivity extends MainActivity {

    ApiInterface mApiInterface;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private SwipeRefreshLayout swipeRefreshLayout;
    public static SiswaActivity sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = LayoutInflater.from(this).inflate(R.layout.activity_siswa, null, false);
        drawer.addView(view, 0);

        setTitle("Daftar Siswa");

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerSiswa);
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
//        ApiClient.BASE_URL = "http://192.168.100.14:8080/rest-api/wpu-rest-server/api/";
        ApiClient.BASE_URL = "http://192.168.43.57:8080/rest-api/wpu-rest-server/api/";
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        sa = this;
        refresh();
    }

    public void refresh() {
        final List list = new ArrayList();
        Call <DataSiswa> siswaCall = mApiInterface.getSiswa();
        siswaCall.enqueue(new Callback <DataSiswa>() {

            @Override
            public void onResponse(Call<DataSiswa> call, Response<DataSiswa> response) {
                DataSiswa dataSiswaList = response.body();
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
            public void onFailure(Call<DataSiswa> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
                Toast.makeText(SiswaActivity.this, "Request Gagal", Toast.LENGTH_LONG).show();
                Toast.makeText(SiswaActivity.this, t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
