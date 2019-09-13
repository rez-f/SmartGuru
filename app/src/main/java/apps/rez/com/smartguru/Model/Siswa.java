package apps.rez.com.smartguru.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Siswa implements Parcelable {

    private String nama;
    private String nis;
    private String nisn;
    private String alamat;
    private String agama;
    private String tempatLahir;
    private String tanggalLahir;
    private String jenisKelamin;
    private String namaAyah;
    private String alamatAyah;
    private String pekerjaanAyah;
    private String namaIbu;
    private String alamatIbu;
    private String pekerjaanIbu;
    private String namaWali;
    private String alamatWali;
    private String pekerjaanWali;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getNisn() {
        return nisn;
    }

    public void setNisn(String nisn) {
        this.nisn = nisn;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getNamaAyah() {
        return namaAyah;
    }

    public void setNamaAyah(String namaAyah) {
        this.namaAyah = namaAyah;
    }

    public String getAlamatAyah() {
        return alamatAyah;
    }

    public void setAlamatAyah(String alamatAyah) {
        this.alamatAyah = alamatAyah;
    }

    public String getPekerjaanAyah() {
        return pekerjaanAyah;
    }

    public void setPekerjaanAyah(String pekerjaanAyah) {
        this.pekerjaanAyah = pekerjaanAyah;
    }

    public String getNamaIbu() {
        return namaIbu;
    }

    public void setNamaIbu(String namaIbu) {
        this.namaIbu = namaIbu;
    }

    public String getAlamatIbu() {
        return alamatIbu;
    }

    public void setAlamatIbu(String alamatIbu) {
        this.alamatIbu = alamatIbu;
    }

    public String getPekerjaanIbu() {
        return pekerjaanIbu;
    }

    public void setPekerjaanIbu(String pekerjaanIbu) {
        this.pekerjaanIbu = pekerjaanIbu;
    }

    public String getNamaWali() {
        return namaWali;
    }

    public void setNamaWali(String namaWali) {
        this.namaWali = namaWali;
    }

    public String getAlamatWali() {
        return alamatWali;
    }

    public void setAlamatWali(String alamatWali) {
        this.alamatWali = alamatWali;
    }

    public String getPekerjaanWali() {
        return pekerjaanWali;
    }

    public void setPekerjaanWali(String pekerjaanWali) {
        this.pekerjaanWali = pekerjaanWali;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.nis);
        dest.writeString(this.nisn);
        dest.writeString(this.alamat);
        dest.writeString(this.agama);
        dest.writeString(this.tempatLahir);
        dest.writeString(this.tanggalLahir);
        dest.writeString(this.jenisKelamin);
        dest.writeString(this.namaAyah);
        dest.writeString(this.alamatAyah);
        dest.writeString(this.pekerjaanAyah);
        dest.writeString(this.namaIbu);
        dest.writeString(this.alamatIbu);
        dest.writeString(this.pekerjaanIbu);
        dest.writeString(this.namaWali);
        dest.writeString(this.alamatWali);
        dest.writeString(this.pekerjaanWali);
    }

    public Siswa() {
    }

    protected Siswa(Parcel in) {
        this.nama = in.readString();
        this.nis = in.readString();
        this.nisn = in.readString();
        this.alamat = in.readString();
        this.agama = in.readString();
        this.tempatLahir = in.readString();
        this.tanggalLahir = in.readString();
        this.jenisKelamin = in.readString();
        this.namaAyah = in.readString();
        this.alamatAyah = in.readString();
        this.pekerjaanAyah = in.readString();
        this.namaIbu = in.readString();
        this.alamatIbu = in.readString();
        this.pekerjaanIbu = in.readString();
        this.namaWali = in.readString();
        this.alamatWali = in.readString();
        this.pekerjaanWali = in.readString();
    }

    public static final Parcelable.Creator<Siswa> CREATOR = new Parcelable.Creator<Siswa>() {
        @Override
        public Siswa createFromParcel(Parcel source) {
            return new Siswa(source);
        }

        @Override
        public Siswa[] newArray(int size) {
            return new Siswa[size];
        }
    };
}
