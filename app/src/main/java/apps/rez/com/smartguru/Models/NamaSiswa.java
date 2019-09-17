package apps.rez.com.smartguru.Models;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class NamaSiswa{

	@SerializedName("data")
	private List<NamaSiswaItem> data;

	@SerializedName("status")
	private boolean status;

	public void setData(List<NamaSiswaItem> data){
		this.data = data;
	}

	public List<NamaSiswaItem> getData(){
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
			"NamaSiswa{" + 
			"data = '" + data + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}