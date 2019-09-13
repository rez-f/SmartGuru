package apps.rez.com.smartguru;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import apps.rez.com.smartguru.Adapter.SiswaAdapter;
import apps.rez.com.smartguru.Model.DataSiswa;
import apps.rez.com.smartguru.Model.Siswa;
import apps.rez.com.smartguru.Model.SiswaItem;
import apps.rez.com.smartguru.Rest.ApiClient;
import apps.rez.com.smartguru.Rest.ApiInterface;
import apps.rez.com.smartguru.listener.ItemClickSupport;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class KelasSiswaFragment extends Fragment {

    ApiInterface mApiInterface;
    List dataList;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public KelasSiswaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kelas_siswa, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerSiswa);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
//        mRecyclerView.setAdapter(new SiswaAdapter(dataList));
//        ApiClient.BASE_URL = "http://192.168.100.14:8080/rest-api/wpu-rest-server/api/";
        ApiClient.BASE_URL = "http://192.168.43.57:8080/rest-api/wpu-rest-server/api/";
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        refresh();

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void refresh() {
        final List list = new ArrayList();
        Call<DataSiswa> siswaCall = mApiInterface.getSiswa();
        siswaCall.enqueue(new Callback<DataSiswa>() {

            @Override
            public void onResponse(Call<DataSiswa> call, final Response<DataSiswa> response) {
                DataSiswa dataSiswaList = response.body();

                if (response.body() != null){
                    for (int i = 0; i < response.body().getData().size(); i++) {
                        list.add(response.body());
                    }
                    Log.d("Retrofit Get","Code : "+response.code());
                    Log.d("Retrofit Get", "Jumlah data Siswa : " + response.body().getData().get(0).getNama());
                    Log.d("Retrofit Get", "Jumlah data Siswa : " + response.body().toString());
                    mAdapter = new SiswaAdapter(list);
                    mRecyclerView.setAdapter(mAdapter);

                    ItemClickSupport.addTo(mRecyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                        @Override
                        public void onItemClicked(RecyclerView recyclerView, int position, View v) {
//                        Toast.makeText(getActivity(), ""+response.body().getData().get(position).getNama(), Toast.LENGTH_SHORT).show();
                            tampilSiswaDetail(response.body().getData().get(position));
                        }
                    });
                }else{
                    Toast.makeText(getActivity(), "Tidak ada respon server", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DataSiswa> call, Throwable t) {
                Toast.makeText(getActivity(), "Request Gagal", Toast.LENGTH_LONG).show();
                Log.e("Retrofit Get", t.toString());
                Toast.makeText(getActivity(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void tampilSiswaDetail(SiswaItem siswaItem) {
        Siswa siswa = new Siswa();
        siswa.setNama(siswaItem.getNama());

        Intent intent = new Intent(getActivity(), SiswaDetailActivity.class);
        intent.putExtra(SiswaDetailActivity.EXTRAS_SISWA, siswa);

        startActivity(intent);
    }
}
