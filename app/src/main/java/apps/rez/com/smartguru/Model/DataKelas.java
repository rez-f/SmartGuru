package apps.rez.com.smartguru.Model;

import java.util.List;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class DataKelas{

	@SerializedName("data")
	private List<KelasItem> data;

	@SerializedName("status")
	private boolean status;

	public void setData(List<KelasItem> data){
		this.data = data;
	}

	public List<KelasItem> getData(){
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
			"DataKelas{" +
					"status = '" + status + '\'' +
					",data = '" + data + '\'' +
			"}";
		}
}