package apps.rez.com.smartguru.Models;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class DataSiswa{

	@SerializedName("data")
	private List<DataSiswaItem> data;

	@SerializedName("status")
	private boolean status;

	public void setData(List<DataSiswaItem> data){
		this.data = data;
	}

	public List<DataSiswaItem> getData(){
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