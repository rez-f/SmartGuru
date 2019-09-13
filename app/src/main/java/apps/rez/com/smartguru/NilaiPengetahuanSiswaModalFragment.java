package apps.rez.com.smartguru;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class NilaiPengetahuanSiswaModalFragment extends DialogFragment {

    private Spinner spinnerKD;

    private String[] germanFeminine = {
            "KD-1",
            "KD-2",
            "KD-3",
            "KD-4",
            "KD-5",
    };

    public NilaiPengetahuanSiswaModalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_modal_nilai_pengetahuan_siswa, container, false);
        // Inflate the layout for this fragment
        getDialog().setTitle("Nilai Pengetahuan");
        getDialog().getWindow().setBackgroundDrawableResource(R.color.colorWhite);

        spinnerKD = view.findViewById(R.id.spinnerKD);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, germanFeminine);
        spinnerKD.setAdapter(adapter);
        spinnerKD.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // memunculkan toast + value Spinner yang dipilih (diambil dari adapter)
//                Toast.makeText(getActivity(), "Selected "+ adapter.getItem(i), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return view;
    }



}
