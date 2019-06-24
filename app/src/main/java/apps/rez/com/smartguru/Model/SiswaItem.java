package apps.rez.com.smartguru.Model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class SiswaItem {

	@SerializedName("nama")
	private String nama;

	@SerializedName("nis")
	private String nis;

	@SerializedName("nisn")
	private String nisn;

	@SerializedName("alamat")
	private String alamat;

	@SerializedName("agama")
	private String agama;

	@SerializedName("tempat_lahir")
	private String tempatLahir;

	@SerializedName("tanggal_lahir")
	private String tanggalLahir;

	@SerializedName("jenis_kelamin")
	private String jenisKelamin;

	@SerializedName("nama_ayah")
	private String namaAyah;

	@SerializedName("alamat_ayah")
	private String alamatAyah;

	@SerializedName("pekerjaan_ayah")
	private String pekerjaanAyah;

	@SerializedName("nama_ibu")
	private String namaIbu;

	@SerializedName("alamat_ibu")
	private String alamatIbu;

	@SerializedName("pekerjaan_ibu")
	private String pekerjaanIbu;

	@SerializedName("nama_wali")
	private String namaWali;

	@SerializedName("alamat_wali")
	private String alamatWali;

	@SerializedName("pekerjaan_wali")
	private String pekerjaanWali;

	public void setNisn(String nisn){
		this.nisn = nisn;
	}

	public String getNisn(){
		return nisn;
	}

	public void setNamaIbu(String namaIbu){
		this.namaIbu = namaIbu;
	}

	public String getNamaIbu(){
		return namaIbu;
	}

	public void setAlamatIbu(String alamatIbu){
		this.alamatIbu = alamatIbu;
	}

	public String getAlamatIbu(){
		return alamatIbu;
	}

	public void setNamaWali(String namaWali){
		this.namaWali = namaWali;
	}

	public String getNamaWali(){
		return namaWali;
	}

	public void setAgama(String agama){
		this.agama = agama;
	}

	public String getAgama(){
		return agama;
	}

	public void setPekerjaanIbu(String pekerjaanIbu){
		this.pekerjaanIbu = pekerjaanIbu;
	}

	public String getPekerjaanIbu(){
		return pekerjaanIbu;
	}

	public void setPekerjaanWali(String pekerjaanWali){
		this.pekerjaanWali = pekerjaanWali;
	}

	public String getPekerjaanWali(){
		return pekerjaanWali;
	}

	public void setAlamatWali(String alamatWali){
		this.alamatWali = alamatWali;
	}

	public String getAlamatWali(){
		return alamatWali;
	}

	public void setAlamat(String alamat){
		this.alamat = alamat;
	}

	public String getAlamat(){
		return alamat;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setTempatLahir(String tempatLahir){
		this.tempatLahir = tempatLahir;
	}

	public String getTempatLahir(){
		return tempatLahir;
	}

	public void setNamaAyah(String namaAyah){
		this.namaAyah = namaAyah;
	}

	public String getNamaAyah(){
		return namaAyah;
	}

	public void setNis(String nis){
		this.nis = nis;
	}

	public String getNis(){
		return nis;
	}

	public void setAlamatAyah(String alamatAyah){
		this.alamatAyah = alamatAyah;
	}

	public String getAlamatAyah(){
		return alamatAyah;
	}

	public void setJenisKelamin(String jenisKelamin){
		this.jenisKelamin = jenisKelamin;
	}

	public String getJenisKelamin(){
		return jenisKelamin;
	}

	public void setPekerjaanAyah(String pekerjaanAyah){
		this.pekerjaanAyah = pekerjaanAyah;
	}

	public String getPekerjaanAyah(){
		return pekerjaanAyah;
	}

	public void setTanggalLahir(String tanggalLahir){
		this.tanggalLahir = tanggalLahir;
	}

	public String getTanggalLahir(){
		return tanggalLahir;
	}

	@Override
 	public String toString(){
		return 
			"SiswaItem{" +
			"nisn = '" + nisn + '\'' + 
			",nama_ibu = '" + namaIbu + '\'' + 
			",alamat_ibu = '" + alamatIbu + '\'' + 
			",nama_wali = '" + namaWali + '\'' + 
			",agama = '" + agama + '\'' + 
			",pekerjaan_ibu = '" + pekerjaanIbu + '\'' + 
			",pekerjaan_wali = '" + pekerjaanWali + '\'' + 
			",alamat_wali = '" + alamatWali + '\'' + 
			",alamat = '" + alamat + '\'' + 
			",nama = '" + nama + '\'' + 
			",tempat_lahir = '" + tempatLahir + '\'' + 
			",nama_ayah = '" + namaAyah + '\'' + 
			",nis = '" + nis + '\'' + 
			",alamat_ayah = '" + alamatAyah + '\'' + 
			",jenis_kelamin = '" + jenisKelamin + '\'' + 
			",pekerjaan_ayah = '" + pekerjaanAyah + '\'' + 
			",tanggal_lahir = '" + tanggalLahir + '\'' + 
			"}";
		}
}