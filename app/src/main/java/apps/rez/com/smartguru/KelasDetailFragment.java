package apps.rez.com.smartguru;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import apps.rez.com.smartguru.Models.DataKelasDetail;
import apps.rez.com.smartguru.Rest.BaseApiService;
import apps.rez.com.smartguru.Rest.UtilsApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class KelasDetailFragment extends Fragment {

    BaseApiService mApiService;
    SharedPrefManager sharedPrefManager;
    TextView namaWalikelas,jumlahSiswa;

    private String ID_KELAS;

    public KelasDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kelas_home, container, false);

        namaWalikelas = view.findViewById(R.id.tvNamaWalikelas);
        jumlahSiswa = view.findViewById(R.id.tvJumlahSiswa);

        sharedPrefManager = new SharedPrefManager(container.getContext());

        ID_KELAS = getArguments().getString("ID_KELAS");

        mApiService = UtilsApi.getAPIService();

        getKelasDetail();

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void getKelasDetail(){
        mApiService.getKelasDetail(Integer.parseInt(ID_KELAS)).enqueue(new Callback<DataKelasDetail>() {
            @Override
            public void onResponse(Call<DataKelasDetail> call, Response<DataKelasDetail> response) {
                DataKelasDetail dataKelasDetail = response.body();

                if (response.body() != null){
                    Log.d("Retrofit Get","Data :"+response.body().getData());

                    namaWalikelas.setText(dataKelasDetail.getData().get(0).getName());
                    jumlahSiswa.setText(String.valueOf(dataKelasDetail.getData().size())+" orang");
                }else{
                    Toast.makeText(getActivity(),"Tidak ada respon server", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DataKelasDetail> call, Throwable t) {
                Toast.makeText(getActivity(), "Request Gagal", Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(), t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
