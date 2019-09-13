package apps.rez.com.smartguru;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class TambahKelasModalFragment extends DialogFragment{
    EditText etJari, etTinggi;
    TextView tvTambah;
    OnOptionDialogListener optionDialogListener;

    public TambahKelasModalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getDialog().setTitle("Tambah Kelas");
        getDialog().getWindow().setBackgroundDrawableResource(R.color.colorWhite);

        return inflater.inflate(R.layout.fragment_modal_tambah_kelas, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etJari = view.findViewById(R.id.etKelas);
        etTinggi = view.findViewById(R.id.etTahunAjaran);
        tvTambah = view.findViewById(R.id.btnTambah);
        tvTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Tambah", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        /*
            Saat attach maka set optionDialogListener dengan listener dari detailCategoryFragment
                */
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.optionDialogListener = null;
    }

    public interface OnOptionDialogListener {
        void onOptionChosen(String text);
    }
}
