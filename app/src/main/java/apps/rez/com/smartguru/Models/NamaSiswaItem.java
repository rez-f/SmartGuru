package apps.rez.com.smartguru.Models;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class NamaSiswaItem {

	@SerializedName("JENIS_KELAMIN")
	private String jENISKELAMIN;

	@SerializedName("NAMA")
	private String nAMA;

	@SerializedName("nama_kelas")
	private String namaKelas;

	public void setJENISKELAMIN(String jENISKELAMIN){
		this.jENISKELAMIN = jENISKELAMIN;
	}

	public String getJENISKELAMIN(){
		return jENISKELAMIN;
	}

	public void setNAMA(String nAMA){
		this.nAMA = nAMA;
	}

	public String getNAMA(){
		return nAMA;
	}

	public void setNamaKelas(String namaKelas){
		this.namaKelas = namaKelas;
	}

	public String getNamaKelas(){
		return namaKelas;
	}

	@Override
 	public String toString(){
		return 
			"NamaSiswaItem{" +
			"jENIS_KELAMIN = '" + jENISKELAMIN + '\'' + 
			",nAMA = '" + nAMA + '\'' + 
			",nama_kelas = '" + namaKelas + '\'' + 
			"}";
		}
}