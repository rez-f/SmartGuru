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

import apps.rez.com.smartguru.Adapter.DataSiswaAdapter;
import apps.rez.com.smartguru.Adapter.SiswaAdapter;
import apps.rez.com.smartguru.Model.Siswa;
import apps.rez.com.smartguru.Models.DataSiswa;
import apps.rez.com.smartguru.Models.DataSiswaItem;
import apps.rez.com.smartguru.Models.NamaSiswa;
import apps.rez.com.smartguru.Models.NamaSiswaItem;
import apps.rez.com.smartguru.Rest.BaseApiService;
import apps.rez.com.smartguru.Rest.UtilsApi;
import apps.rez.com.smartguru.listener.ItemClickSupport;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class KelasSiswaFragment extends Fragment {

    BaseApiService mApiService;
    List dataList;

    SharedPrefManager sharedPrefManager;

    private String ID_KELAS;

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
        mRecyclerView = view.findViewById(R.id.recyclerSiswa);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        sharedPrefManager = new SharedPrefManager(container.getContext());

        ID_KELAS = getArguments().getString("ID_KELAS");

        mApiService = UtilsApi.getAPIService(); // meng-init yang ada di package apihelper

        getSiswaList();

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void getSiswaList() {
        final List list = new ArrayList();

        mApiService.getSiswaKelas(Integer.parseInt(ID_KELAS)).enqueue(new Callback<DataSiswa>() {
            @Override
            public void onResponse(Call<DataSiswa> call, final Response<DataSiswa> response) {
                DataSiswa dataSiswaList = response.body();

                if (response.body() != null){
                    for (int i = 0; i < response.body().getData().size(); i++) {
                        list.add(response.body());
                    }
                    Log.d("Retrofit Get","Code : "+response.code());
                    Log.d("Retrofit Get", "Jumlah data Siswa : " + response.body().getData().get(0).getNAMA());
                    Log.d("Retrofit Get", "Jumlah data Siswa : " + response.body().toString());
                    mAdapter = new DataSiswaAdapter(list);
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

    private void tampilSiswaDetail(DataSiswaItem siswaItem) {
        Siswa siswa = new Siswa();

        siswa.setNama(siswaItem.getNAMA());
        siswa.setNis(siswaItem.getNIS());
        siswa.setNisn(siswaItem.getNISN());
        siswa.setTempatLahir(siswaItem.getTEMPATLAHIR());
        siswa.setTanggalLahir(siswaItem.getTANGGALLAHIR());
        siswa.setJenisKelamin(siswaItem.getJENISKELAMIN());
        siswa.setAgama(siswaItem.getAGAMA());
        siswa.setAlamat(siswaItem.getALAMAT());
        siswa.setNamaAyah(siswaItem.getNAMAAYAH());
        siswa.setPekerjaanAyah(siswaItem.getPEKERJAANAYAH());
        siswa.setNamaIbu(siswaItem.getNAMAIBU());
        siswa.setPekerjaanIbu(siswaItem.getPEKERJAANIBU());
        siswa.setAlamatAyah(siswaItem.getALAMATORTUJALAN());

        Intent intent = new Intent(getActivity(), SiswaDetailActivity.class);
        intent.putExtra(SiswaDetailActivity.EXTRAS_SISWA, siswa);

        startActivity(intent);
    }
}
