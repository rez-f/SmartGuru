package apps.rez.com.smartguru.Models;

import java.util.List;

import javax.annotation.Generated;

import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class DataSiswaKelas {

    @SerializedName("data")
    private List<DataSiswaKelasItem> data;

    @SerializedName("status")
    private boolean status;

    public void setData(List<DataSiswaKelasItem> data) {
        this.data = data;
    }

    public List<DataSiswaKelasItem> getData() {
        return data;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    @Override
    public String toString() {
        return
                "DataSiswaKelas{" +
                        "data = '" + data + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }
}