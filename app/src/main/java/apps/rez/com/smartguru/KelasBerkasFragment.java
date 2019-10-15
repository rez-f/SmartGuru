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
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import apps.rez.com.smartguru.Rest.UtilsApi;


/**
 * A simple {@link Fragment} subclass.
 */
public class KelasBerkasFragment extends Fragment implements View.OnClickListener{

    private int ID_MAPEL;
    private String ID_KELAS;
    private StringBuilder textUrl;
    private boolean fileServerExist;

    private ImageView download;

    public KelasBerkasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kelas_berkas, container, false);

        getServerIpFromFile();

        download = view.findViewById(R.id.ivDownload);
        download.setOnClickListener(this);

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
        Uri uri = Uri.parse(textUrl+"/nilai/transkrip?idKelas="+ ID_KELAS +"&idMapel="+ ID_MAPEL);

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
