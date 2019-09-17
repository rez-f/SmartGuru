package apps.rez.com.smartguru.Models;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class KelasItem {

	@SerializedName("MATA_PELAJARAN")
	private String mATAPELAJARAN;

	@SerializedName("nip_guru")
	private String nipGuru;

	@SerializedName("nama_kelas")
	private String namaKelas;

	@SerializedName("id_TA")
	private String idTA;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id_mapel")
	private String idMapel;

	@SerializedName("deleted_at")
	private Object deletedAt;

	@SerializedName("id_walikelas")
	private String idWalikelas;

	@SerializedName("KELOMPOK")
	private String kELOMPOK;

	@SerializedName("KETERAMPILAN")
	private String kETERAMPILAN;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("user_id")
	private String userId;

	@SerializedName("PENGETAHUAN")
	private String pENGETAHUAN;

	@SerializedName("id_kelas")
	private String idKelas;

	@SerializedName("id")
	private String id;

	@SerializedName("nama_guru")
	private String namaGuru;

	@SerializedName("NOMOR")
	private Object nOMOR;

	public void setMATAPELAJARAN(String mATAPELAJARAN){
		this.mATAPELAJARAN = mATAPELAJARAN;
	}

	public String getMATAPELAJARAN(){
		return mATAPELAJARAN;
	}

	public void setNipGuru(String nipGuru){
		this.nipGuru = nipGuru;
	}

	public String getNipGuru(){
		return nipGuru;
	}

	public void setNamaKelas(String namaKelas){
		this.namaKelas = namaKelas;
	}

	public String getNamaKelas(){
		return namaKelas;
	}

	public void setIdTA(String idTA){
		this.idTA = idTA;
	}

	public String getIdTA(){
		return idTA;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setIdMapel(String idMapel){
		this.idMapel = idMapel;
	}

	public String getIdMapel(){
		return idMapel;
	}

	public void setDeletedAt(Object deletedAt){
		this.deletedAt = deletedAt;
	}

	public Object getDeletedAt(){
		return deletedAt;
	}

	public void setIdWalikelas(String idWalikelas){
		this.idWalikelas = idWalikelas;
	}

	public String getIdWalikelas(){
		return idWalikelas;
	}

	public void setKELOMPOK(String kELOMPOK){
		this.kELOMPOK = kELOMPOK;
	}

	public String getKELOMPOK(){
		return kELOMPOK;
	}

	public void setKETERAMPILAN(String kETERAMPILAN){
		this.kETERAMPILAN = kETERAMPILAN;
	}

	public String getKETERAMPILAN(){
		return kETERAMPILAN;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

	public void setPENGETAHUAN(String pENGETAHUAN){
		this.pENGETAHUAN = pENGETAHUAN;
	}

	public String getPENGETAHUAN(){
		return pENGETAHUAN;
	}

	public void setIdKelas(String idKelas){
		this.idKelas = idKelas;
	}

	public String getIdKelas(){
		return idKelas;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setNamaGuru(String namaGuru){
		this.namaGuru = namaGuru;
	}

	public String getNamaGuru(){
		return namaGuru;
	}

	public void setNOMOR(Object nOMOR){
		this.nOMOR = nOMOR;
	}

	public Object getNOMOR(){
		return nOMOR;
	}

	@Override
 	public String toString(){
		return 
			"KelasItem{" +
			"mATA_PELAJARAN = '" + mATAPELAJARAN + '\'' + 
			",nip_guru = '" + nipGuru + '\'' + 
			",nama_kelas = '" + namaKelas + '\'' + 
			",id_TA = '" + idTA + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id_mapel = '" + idMapel + '\'' + 
			",deleted_at = '" + deletedAt + '\'' + 
			",id_walikelas = '" + idWalikelas + '\'' + 
			",kELOMPOK = '" + kELOMPOK + '\'' + 
			",kETERAMPILAN = '" + kETERAMPILAN + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",user_id = '" + userId + '\'' + 
			",pENGETAHUAN = '" + pENGETAHUAN + '\'' + 
			",id_kelas = '" + idKelas + '\'' + 
			",id = '" + id + '\'' + 
			",nama_guru = '" + namaGuru + '\'' + 
			",nOMOR = '" + nOMOR + '\'' + 
			"}";
		}
}