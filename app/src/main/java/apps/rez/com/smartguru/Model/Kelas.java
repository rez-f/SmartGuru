package apps.rez.com.smartguru.Model;

import com.google.gson.annotations.SerializedName;

public class Kelas{
    @SerializedName("id")
    private String id;
    @SerializedName("kelas")
    private String kelas;
    @SerializedName("mataPelajaran")
    private String mataPelajaran;

    public Kelas(){

    }

    public Kelas(String id, String kelas, String mataPelajaran) {
        this.id = id;
        this.kelas = kelas;
        this.mataPelajaran = mataPelajaran;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
}