package apps.rez.com.smartguru.Model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class KelasItem {

	@SerializedName("kelas")
	private String kelas;

	@SerializedName("id")
	private String id;

	@SerializedName("mata_pelajaran")
	private String mataPelajaran;

	public void setKelas(String kelas){
		this.kelas = kelas;
	}

	public String getKelas(){
		return kelas;
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
			",kelas = '" + kelas + '\'' +
			",mata_pelajaran = '" + mataPelajaran + '\'' + 
			"}";
		}
}