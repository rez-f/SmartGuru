package apps.rez.com.smartguru.Model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class KelasItem {

    @SerializedName("nama_kelas")
    private String nama_kelas;

	@SerializedName("id")
	private String id;

	@SerializedName("mata_pelajaran")
	private String mataPelajaran;

	public void setKelas(String kelas){
        this.nama_kelas = kelas;
	}

	public String getKelas(){
        return nama_kelas;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setMataPelajaran(String mataPelajaran){
		this.mataPelajaran = mataPelajaran;
	}

	public String getMataPelajaran(){
		return mataPelajaran;
	}

	@Override
 	public String toString(){
		return 
			"KelasItem{" +
			"id = '" + id + '\'' +
                    ",nama_kelas = '" + nama_kelas + '\'' +
                    ",MATA_PELAJARAN = '" + mataPelajaran + '\'' +
			"}";
		}
}