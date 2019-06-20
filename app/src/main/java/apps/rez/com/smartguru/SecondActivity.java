package apps.rez.com.smartguru;

import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import apps.rez.com.smartguru.Adapter.KelasAdapter;
import apps.rez.com.smartguru.Model.DataKelas;
import apps.rez.com.smartguru.Rest.ApiClient;
import apps.rez.com.smartguru.Rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mig on 25/09/2018.
 */

public class SecondActivity extends MainActivity {

    ApiInterface mApiInterface;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private SwipeRefreshLayout swipeRefreshLayout;
    public static SecondActivity sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = LayoutInflater.from(this).inflate(R.layout.home_activity, null, false);
        drawer.addView(view, 0);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerKelas);
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
        mRecyclerView.setAdapter(new KelasAdapter(dataList));
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        sa = this;
        refresh();
    }

    public void refresh() {
        final List list = new ArrayList();
        Call<DataKelas> kelasCall = mApiInterface.getKelas();
        kelasCall.enqueue(new Callback<DataKelas>() {

            @Override
            public void onResponse(Call<DataKelas> call, Response<DataKelas> response) {
                DataKelas KelasList = response.body();
                for (int i = 0; i < response.body().getData().size(); i++) {
                    list.add(response.body());
                }
                Log.d("Retrofit Get", "Jumlah data Kontak : " + String.valueOf(response.body().toString()));
                mAdapter = new KelasAdapter(list);
                mRecyclerView.setAdapter(mAdapter);
                swipeRefreshLayout.setEnabled(false);
            }

            @Override
            public void onFailure(Call<DataKelas> call, Throwable t) {
                Toast.makeText(SecondActivity.this, "Request Gagal", Toast.LENGTH_LONG).show();
                Log.e("Retrofit Get", t.toString());
                Toast.makeText(SecondActivity.this, t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
