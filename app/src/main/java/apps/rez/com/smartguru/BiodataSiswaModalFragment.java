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
public class BiodataSiswaModalFragment extends DialogFragment {

    public BiodataSiswaModalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_modal_biodata_siswa, container, false);
        // Inflate the layout for this fragment
        getDialog().setTitle("Biodata");
        getDialog().getWindow().setBackgroundDrawableResource(R.color.colorWhite);

        return view;
    }

}
