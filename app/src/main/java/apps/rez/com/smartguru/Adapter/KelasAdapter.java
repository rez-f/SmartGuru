package apps.rez.com.smartguru.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import apps.rez.com.smartguru.Model.DataKelas;
import apps.rez.com.smartguru.R;

/**
 * Created by root on 2/3/17.
 */

public class KelasAdapter extends RecyclerView.Adapter<KelasAdapter.MyViewHolder>{

    List<DataKelas> mKelasList;

    public KelasAdapter(List<DataKelas> KelasList) {
        mKelasList = KelasList;
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent,int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_kelas, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (MyViewHolder holder,final int position){
        holder.mTextViewKelas.setText(mKelasList.get(position).getData().get(position).getKelas());
        holder.mTextViewMataPelajaran.setText(mKelasList.get(position).getData().get(position).getMataPelajaran());
    }

    @Override
    public int getItemCount () {
        return mKelasList.size();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewId, mTextViewKelas, mTextViewMataPelajaran;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewKelas = (TextView) itemView.findViewById(R.id.tvKelas);
            mTextViewMataPelajaran = (TextView) itemView.findViewById(R.id.tvMataPelajaran);
        }
    }
}