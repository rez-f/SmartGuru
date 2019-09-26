package apps.rez.com.smartguru.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Kelas implements Parcelable {
    private int id;
    private String kelas;
    private String mataPelajaran;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getMataPelajaran() {
        return mataPelajaran;
    }

    public void setMataPelajaran(String mataPelajaran) {
        this.mataPelajaran = mataPelajaran;
    }

    public static Creator<Kelas> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.kelas);
        dest.writeString(this.mataPelajaran);
    }

    public Kelas() {
    }

    protected Kelas(Parcel in) {
        this.id = in.readInt();
        this.kelas = in.readString();
        this.mataPelajaran = in.readString();
    }

    public static final Parcelable.Creator<Kelas> CREATOR = new Parcelable.Creator<Kelas>() {
        @Override
        public Kelas createFromParcel(Parcel source) {
            return new Kelas(source);
        }

        @Override
        public Kelas[] newArray(int size) {
            return new Kelas[size];
        }
    };
}
