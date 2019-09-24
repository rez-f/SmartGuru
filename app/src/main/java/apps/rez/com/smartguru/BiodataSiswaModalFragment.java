package apps.rez.com.smartguru;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class BiodataSiswaModalFragment extends DialogFragment {
    TextView tvNama, tvNis, tvNisn, tvTempatLahir, tvTanggalLahir, tvJenisKelamin, tvAgama, tvAlamat, tvNamaAyah, tvPekerjaanAyah, tvNamaIbu,
            tvPekerjaanIbu, tvAlamatOrangTua;

    public BiodataSiswaModalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_modal_biodata_siswa, container, false);
        // Inflate the layout for this fragment
        getDialog().setTitle("Biodata");
        Objects.requireNonNull(getDialog().getWindow()).setBackgroundDrawableResource(R.color.colorWhite);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvNama = view.findViewById(R.id.tvNamaSiswa);
        tvNis = view.findViewById(R.id.tvNIS);
        tvNisn = view.findViewById(R.id.tvNISN);
        tvTempatLahir = view.findViewById(R.id.tvTempatLahir);
        tvTanggalLahir = view.findViewById(R.id.tvTanggalLahir);
        tvJenisKelamin = view.findViewById(R.id.tvJenisKelamin);
        tvAgama = view.findViewById(R.id.tvAgama);
        tvAlamat = view.findViewById(R.id.tvAlamat);
        tvNamaAyah = view.findViewById(R.id.tvNamaAyah);
        tvPekerjaanAyah = view.findViewById(R.id.tvPekerjaanAyah);
        tvNamaIbu = view.findViewById(R.id.tvNamaIbu);
        tvPekerjaanIbu = view.findViewById(R.id.tvPekerjaanIbu);
        tvAlamatOrangTua = view.findViewById(R.id.tvAlamatOrangTua);

        assert getArguments() != null;
        tvNama.setText(getArguments().getString("NAMA_SISWA"));
        tvNis.setText(getArguments().getString("NIS_SISWA"));
        tvNisn.setText(getArguments().getString("NISN_SISWA"));
        tvTempatLahir.setText(getArguments().getString("TEMPAT_LAHIR_SISWA"));
        tvTanggalLahir.setText(getArguments().getString("TANGGAL_LAHIR_SISWA"));
        tvJenisKelamin.setText(getArguments().getString("JENIS_KELAMIN_SISWA"));
        tvAgama.setText(getArguments().getString("AGAMA_SISWA"));
        tvAlamat.setText(getArguments().getString("ALAMAT_SISWA"));
        tvNamaAyah.setText(getArguments().getString("NAMA_AYAH_SISWA"));
        tvPekerjaanAyah.setText(getArguments().getString("PEKERJAAN_AYAH_SISWA"));
        tvNamaIbu.setText(getArguments().getString("NAMA_IBU_SISWA"));
        tvPekerjaanIbu.setText(getArguments().getString("PEKERJAAN_IBU_SISWA"));
        tvAlamatOrangTua.setText(getArguments().getString("ALAMAT_AYAH_SISWA"));
    }
}
