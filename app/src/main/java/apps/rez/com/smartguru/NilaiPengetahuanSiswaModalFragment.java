package apps.rez.com.smartguru;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import apps.rez.com.smartguru.Rest.BaseApiService;
import apps.rez.com.smartguru.Rest.UtilsApi;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class NilaiPengetahuanSiswaModalFragment extends DialogFragment implements View.OnClickListener {

    private TextView mataPelajaran, input, batal;
    private EditText etNilaiNph,etNilaiUts,etNilaiUas,etNilaiRata;

    ProgressDialog loading;

    BaseApiService mApiService;
    private StringBuilder textUrl;
    private boolean fileServerExist;
    private int ID_SISWA,ID_MAPEL,nilaiNph,nilaiUts,nilaiUas,nilaiRata;

    public NilaiPengetahuanSiswaModalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_modal_nilai_pengetahuan_siswa, container, false);
        // Inflate the layout for this fragment
        getDialog().setTitle("Input Nilai Pengetahuan");

        mataPelajaran = view.findViewById(R.id.tvMataPelajaran);
        input = view.findViewById(R.id.tvInput);
        batal = view.findViewById(R.id.tvBatal);
        etNilaiNph = view.findViewById(R.id.nilaiNph);
        etNilaiUts = view.findViewById(R.id.nilaiUts);
        etNilaiUas = view.findViewById(R.id.nilaiUas);
        etNilaiRata = view.findViewById(R.id.nilaiRata);
        
        mataPelajaran.setText(getArguments().getString("MATA_PELAJARAN"));
        input.setOnClickListener(this);
        batal.setOnClickListener(this);

        assert getArguments() != null;
        ID_SISWA = Integer.parseInt(getArguments().getString("ID_SISWA"));
        ID_MAPEL = getArguments().getInt("ID_MAPEL");

        getServerIpFromFile();

        if (fileServerExist) {
            UtilsApi.BASE_URL_API = "" + textUrl;
        }else{
            Toast.makeText(getActivity(), "File tidak ada", Toast.LENGTH_SHORT).show();
        }

        mApiService = UtilsApi.getAPIService();
        
        return view;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.tvInput) {
            if (TextUtils.isEmpty(etNilaiNph.getText().toString()) || TextUtils.isEmpty(etNilaiUts.getText().toString()) ||
                    TextUtils.isEmpty(etNilaiUas.getText().toString()) || TextUtils.isEmpty(etNilaiRata.getText().toString())){
                Toast.makeText(getActivity(), "Mohon isi semua field", Toast.LENGTH_SHORT).show();
            }else{
                nilaiNph = Integer.parseInt(etNilaiNph.getText().toString());
                nilaiUts = Integer.parseInt(etNilaiUts.getText().toString());
                nilaiUas = Integer.parseInt(etNilaiUas.getText().toString());
                nilaiRata = Integer.parseInt(etNilaiRata.getText().toString());
                loading = ProgressDialog.show(getActivity(), null, "Menyimpan Data...", true, false);

                new android.os.Handler().postDelayed(
                        new Runnable() {
                            public void run() {
                                submitNilai();
                            }
                        }, 2000);
            }
        }else if(view.getId() == R.id.tvBatal){
            dismiss();
        }
    }

    private void submitNilai(){
        mApiService.inputNilaiPengetahuan(ID_SISWA,ID_MAPEL,nilaiNph,nilaiUts,nilaiUas,nilaiRata).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    loading.dismiss();
                    dismiss();
                    Log.d("Retrofit", "Success");
                    Toast.makeText(getActivity(), "Input Nilai Berhasil", Toast.LENGTH_LONG).show();
                }else{
                    if (response.code() == 404){
                        loading.dismiss();
                        dismiss();
                        Toast.makeText(getActivity(), "Not Found", Toast.LENGTH_SHORT).show();
                    }else{
                        loading.dismiss();
                        dismiss();
                        Toast.makeText(getActivity(), "Terjadi Kesalahan", Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                loading.dismiss();
                dismiss();
                Log.d("Retrofit", "Fail");
                Log.d("Retrofit", "Failure  :" + t.toString());
                Toast.makeText(getActivity(), "Gagal terhubung ke server", Toast.LENGTH_SHORT).show();
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
