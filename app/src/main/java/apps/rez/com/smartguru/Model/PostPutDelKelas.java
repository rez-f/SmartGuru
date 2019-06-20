package apps.rez.com.smartguru.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by root on 2/3/17.
 */

public class PostPutDelKelas {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Kelas mKelas;
    @SerializedName("message")
    String message;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Kelas getKontak() {
        return mKelas;
    }
    public void setKontak(Kelas Kelas) {
        mKelas = Kelas;
    }

}