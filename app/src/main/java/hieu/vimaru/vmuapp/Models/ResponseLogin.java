package hieu.vimaru.vmuapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseLogin {
    @SerializedName("statusCode")
    @Expose
    private int statusCode;
    @SerializedName("data")
    @Expose
    private Data data;

    public ResponseLogin() {
    }

    public ResponseLogin(int statusCode, Data data) {
        this.statusCode = statusCode;
        this.data = data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
