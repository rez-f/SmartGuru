package apps.rez.com.smartguru;


import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;


/**
 * A simple {@link Fragment} subclass.
 */
public class KelasBerkasFragment extends Fragment implements View.OnClickListener{

    private String ID_KELAS;
    private int ID_MAPEL;

    private Button transkrip;
    private ProgressDialog loading;

    public KelasBerkasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kelas_berkas, container, false);

        transkrip = view.findViewById(R.id.btnTranskrip);
        transkrip.setOnClickListener(this);

        ID_KELAS = getArguments().getString("ID_KELAS");
        ID_MAPEL = getArguments().getInt("ID_MAPEL");

        return view ;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(View view) {

        DownloadManager downloadmanager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse("http://192.168.100.14/k13-RestCI/api/nilai/transkrip?idKelas="+ ID_KELAS +"&idMapel="+ ID_MAPEL);

        Toast.makeText(getActivity(), uri.toString(), Toast.LENGTH_LONG).show();

        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setTitle("Transkrip Nilai");
        request.setDescription("Downloading");
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setVisibleInDownloadsUi(false);
        File file = new File(Environment.getExternalStorageDirectory(), "/smartguru/transkrip.pdf");
        request.setDestinationUri(Uri.fromFile(file));
        downloadmanager.enqueue(request);
    }
}
