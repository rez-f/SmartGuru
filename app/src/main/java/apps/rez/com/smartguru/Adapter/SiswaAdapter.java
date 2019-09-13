package apps.rez.com.smartguru.Adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;

import java.util.List;
import java.util.Random;

import apps.rez.com.smartguru.Model.DataSiswa;
import apps.rez.com.smartguru.R;

/**
 * Created by root on 2/3/17.
 */

public class SiswaAdapter extends RecyclerView.Adapter<SiswaAdapter.MyViewHolder>{

    private List<DataSiswa> mSiswaList;
    private TextDrawable mDrawable;
    private String mNama;
    private int[] red = {63,76,244,233,156,103,0,255,139,255,205,33,255,255,};
    private int[] green = {81,175,67,30,39,58,188,152,195,235,220,150,193,87,169};
    private int[] blue = {181,80,54,99,176,183,212,0,74,59,57,243,7,34,244};
    private int index = 0;
    Random random;

    public SiswaAdapter(List<DataSiswa> SiswaList) {
        mSiswaList = SiswaList;
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent,int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_siswa, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        random = new Random();
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (MyViewHolder holder,final int position){
        mNama = mSiswaList.get(position).getData().get(position).getNama();
        holder.mTextViewNamaSiswa.setText(mNama);
        holder.mTextViewNIS.setText(mSiswaList.get(position).getData().get(position).getNis());
        holder.mTextViewJenisKelamin.setText(mSiswaList.get(position).getData().get(position).getJenisKelamin());

        for (int i = 0; i < position+1 ; i++){
            if (index == red.length-1){
                index = 0;
            }else {
                index++;
            }

            Log.d("Nilai Index","Index = "+index);

            mDrawable = TextDrawable.builder()
                    .buildRound(String.valueOf(mNama.charAt(0)), Color.rgb(red[index],green[index],blue[index]));
            holder.mImageViewLetter.setImageDrawable(mDrawable);
        }
    }

    @Override
    public int getItemCount () {
        return mSiswaList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewNamaSiswa,mTextViewNIS,mTextViewJenisKelamin;
        public ImageView mImageViewLetter;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewNamaSiswa = (TextView) itemView.findViewById(R.id.tvNamaSiswa);
            mTextViewNIS = (TextView) itemView.findViewById(R.id.tvNIS);
            mTextViewJenisKelamin = (TextView) itemView.findViewById(R.id.tvJenisKelamin);
            mImageViewLetter = (ImageView) itemView.findViewById(R.id.ivLetter);
        }
    }
}