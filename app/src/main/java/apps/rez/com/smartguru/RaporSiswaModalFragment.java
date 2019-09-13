package apps.rez.com.smartguru;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class RaporSiswaModalFragment extends DialogFragment {


    public RaporSiswaModalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getDialog().setTitle("Rapor");
        getDialog().getWindow().setBackgroundDrawableResource(R.color.colorWhite);
        return inflater.inflate(R.layout.fragment_modal_rapor_siswa, container, false);
    }

}
