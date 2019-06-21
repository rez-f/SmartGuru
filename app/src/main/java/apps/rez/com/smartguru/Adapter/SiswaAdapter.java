package apps.rez.com.smartguru.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import apps.rez.com.smartguru.Model.DataSiswa;
import apps.rez.com.smartguru.Model.Siswa;
import apps.rez.com.smartguru.R;

public class SiswaAdapter extends RecyclerView.Adapter<SiswaAdapter.MyViewHolder> {

    List<DataSiswa> mSiswaList;

    public SiswaAdapter(List<DataSiswa> KelasList) {
        mSiswaList = KelasList;
    }

    @Override
    public SiswaAdapter.MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.kelas_list, parent, false);
        SiswaAdapter.MyViewHolder mViewHolder = new SiswaAdapter.MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (SiswaAdapter.MyViewHolder holder, final int position){
        holder.mTextViewNama.setText(mSiswaList.get(position).getData().get(position).getNama());
    }

    @Override
    public int getItemCount () {
        return mSiswaList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewNama, mTextViewMataKelas;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewNama = (TextView) itemView.findViewById(R.id.tvNamaSiswa);
            mTextViewMataKelas = (TextView) itemView.findViewById(R.id.tvKelasSiswa);
        }
    }
}
