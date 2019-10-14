package apps.rez.com.smartguru.Models;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class DataKelasDetail{

	@SerializedName("data")
	private List<KelasDetailItem> data;

	@SerializedName("status")
	private boolean status;

	public void setData(List<KelasDetailItem> data){
		this.data = data;
	}

	public List<KelasDetailItem> getData(){
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
			"DataKelasDetail{" +
			"data = '" + data + '\'' +
			",status = '" + status + '\'' +
			"}";
		}
}