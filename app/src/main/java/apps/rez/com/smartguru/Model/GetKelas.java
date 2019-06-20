package apps.rez.com.smartguru.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by root on 2/3/17.
 */

public class GetKelas {
    @SerializedName("status")
    List<String> status;
    @SerializedName("result")
    List<Kelas> listDataKelas;
    @SerializedName("message")
    List<String> message;
    public List<String> getStatus() {
        return status;
    }
    public void setStatus(List<String> status) {
        this.status = status;
    }
    public List<String> getMessage() {
        return message;
    }
    public void setMessage(List<String> message) {
        this.message = message;
    }
    public List<Kelas> getListDataKelas() {
        return listDataKelas;
    }
    public void setListDataKelas(List<Kelas> listDataKelas) {
        this.listDataKelas = listDataKelas;
    }
}