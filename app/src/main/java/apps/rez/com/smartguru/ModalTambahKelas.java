package apps.rez.com.smartguru;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ModalTambahKelas extends DialogFragment implements View.OnClickListener{
    EditText etJari,etTinggi;
    TextView tvHasil;
    TextView tvHitung;
    OnOptionDialogListener optionDialogListener;

    public ModalTambahKelas() {
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
        etJari = (EditText) view.findViewById(R.id.etPrismaAlas);
        etTinggi = (EditText) view.findViewById(R.id.etPrismaTinggi);
        tvHasil = (TextView) view.findViewById(R.id.tvHasil);
        tvHitung = (TextView) view.findViewById(R.id.btnHitung);
        tvHitung.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (TextUtils.isEmpty(etJari.getText()) | TextUtils.isEmpty((etTinggi.getText()))){
            tvHasil.setText("Isi nilai dahulu");
        }else{
            String nilaiAlas = etJari.getText().toString().trim();
            String nilaiTinggi = etTinggi.getText().toString().trim();

            double a = Double.parseDouble(nilaiAlas);
            double t = Double.parseDouble(nilaiTinggi);
            double hasil = (1 * a * t ) * t;
            tvHasil.setText(String.valueOf(hasil));
        }

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

    public interface OnOptionDialogListener{
        void onOptionChosen(String text);
    }
}
