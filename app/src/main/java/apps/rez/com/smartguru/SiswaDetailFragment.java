package apps.rez.com.smartguru;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class SiswaDetailFragment extends Fragment implements View.OnClickListener{

    private String nama;
    private CardView biodata;
    private CardView pengetahuan;
    private CardView keterampilan;
    private CardView rapor;
    private FragmentActivity myContext;
    private FragmentManager fragmentManager;

    private Bundle bundle;

    public SiswaDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_siswa_detail, container, false);

        bundle = new Bundle();

        assert getArguments() != null;

        bundle.putInt("ID_KELAS", getArguments().getInt("ID_KELAS"));
        bundle.putInt("ID_MAPEL", getArguments().getInt("ID_MAPEL"));
        bundle.putString("MATA_PELAJARAN", getArguments().getString("MATA_PELAJARAN"));
        bundle.putString("ID_SISWA", getArguments().getString("ID_SISWA"));
        bundle.putString("NAMA_SISWA", getArguments().getString("NAMA_SISWA"));
        bundle.putString("NIS_SISWA", getArguments().getString("NIS_SISWA"));
        bundle.putString("NISN_SISWA", getArguments().getString("NISN_SISWA"));
        bundle.putString("TEMPAT_LAHIR_SISWA", getArguments().getString("TEMPAT_LAHIR_SISWA"));
        bundle.putString("TANGGAL_LAHIR_SISWA", getArguments().getString("TANGGAL_LAHIR_SISWA"));
        bundle.putString("JENIS_KELAMIN_SISWA", getArguments().getString("JENIS_KELAMIN_SISWA"));
        bundle.putString("AGAMA_SISWA", getArguments().getString("AGAMA_SISWA"));
        bundle.putString("ALAMAT_SISWA", getArguments().getString("ALAMAT_SISWA"));
        bundle.putString("NAMA_AYAH_SISWA", getArguments().getString("NAMA_AYAH_SISWA"));
        bundle.putString("PEKERJAAN_AYAH_SISWA", getArguments().getString("PEKERJAAN_AYAH_SISWA"));
        bundle.putString("NAMA_IBU_SISWA", getArguments().getString("NAMA_IBU_SISWA"));
        bundle.putString("PEKERJAAN_IBU_SISWA", getArguments().getString("PEKERJAAN_IBU_SISWA"));
        bundle.putString("ALAMAT_AYAH_SISWA", getArguments().getString("ALAMAT_AYAH_SISWA"));

        biodata = view.findViewById(R.id.cvBioSiswa);
        pengetahuan = view.findViewById(R.id.cvNilaiPengetahuanSiswa);
        keterampilan = view.findViewById(R.id.cvNilaiKeterampilanSiswa);
        rapor = view.findViewById(R.id.cvRaporSiswa);

        biodata.setOnClickListener(this);
        pengetahuan.setOnClickListener(this);
//        keterampilan.setOnClickListener(this);
//        rapor.setOnClickListener(this);
//        rapor.setVisibility(View.GONE);

        nama = getArguments().getString("nama");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        myContext=(FragmentActivity) context;
        super.onAttach(context);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.cvBioSiswa) {

            BiodataSiswaModalFragment biodataSiswaModalFragment = new BiodataSiswaModalFragment();
            fragmentManager = myContext.getSupportFragmentManager();
            biodataSiswaModalFragment.setArguments(bundle);
            biodataSiswaModalFragment.show(fragmentManager,"Fragment Biodata Siswa");

        }else if(view.getId() == R.id.cvNilaiPengetahuanSiswa){

            NilaiPengetahuanSiswaModalFragment nilaiPengetahuanSiswaModalFragment = new NilaiPengetahuanSiswaModalFragment();
            fragmentManager = myContext.getSupportFragmentManager();
            nilaiPengetahuanSiswaModalFragment.setArguments(bundle);
            nilaiPengetahuanSiswaModalFragment.show(fragmentManager,"Fragment Nilai Pengetahuan Siswa");

        }else if (view.getId() == R.id.cvNilaiKeterampilanSiswa){

            NilaiKeterampilanModalFragment nilaiKeterampilanModalFragment = new NilaiKeterampilanModalFragment();
            fragmentManager = myContext.getSupportFragmentManager();
            nilaiKeterampilanModalFragment.show(fragmentManager,"Fragment Nilai Keterampilan Siswa");

        }else if (view.getId() == R.id.cvRaporSiswa){

            RaporSiswaModalFragment raporSiswaModalFragment = new RaporSiswaModalFragment();
            fragmentManager = myContext.getSupportFragmentManager();
            raporSiswaModalFragment.show(fragmentManager,"Fragment Rapor Siswa");

        }
    }
}
