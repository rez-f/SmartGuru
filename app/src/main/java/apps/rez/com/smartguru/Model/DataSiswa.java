package apps.rez.com.smartguru.Model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class DataSiswa{

	@SerializedName("data")
	private List<SiswaItem> data;

	@SerializedName("status")
	private boolean status;

	public void setData(List<SiswaItem> data){
		this.data = data;
	}

	public List<SiswaItem> getData(){
		return data;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"DataSiswa{" + 
			"data = '" + data + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}