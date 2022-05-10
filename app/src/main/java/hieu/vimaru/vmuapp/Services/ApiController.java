package hieu.vimaru.vmuapp.Services;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import hieu.vimaru.vmuapp.Models.ResponseLogin;
import hieu.vimaru.vmuapp.Models.User;
import hieu.vimaru.vmuapp.Models.res;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiController {
    String DOMAIN = "https://11de-2402-800-61d9-193a-6c32-57a6-f468-d4fa.ap.ngrok.io/";
    Gson gson =new GsonBuilder().setLenient().create();

    ApiController apiService = new Retrofit.Builder()
            .baseUrl(DOMAIN)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiController.class);

    @POST("auth/login")
    Call<ResponseLogin> login(@Body User user);
}
