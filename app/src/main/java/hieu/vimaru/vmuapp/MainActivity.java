package hieu.vimaru.vmuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;

import org.json.JSONObject;

import hieu.vimaru.vmuapp.Models.ResponseLogin;
import hieu.vimaru.vmuapp.Models.User;
import hieu.vimaru.vmuapp.Models.res;
import hieu.vimaru.vmuapp.Services.ApiController;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView changePass;
    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);
        changePass = (TextView) findViewById(R.id.changePassword);

        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn);

        sharedPreferences = getSharedPreferences("jwt",MODE_PRIVATE);

        String jwtShare= sharedPreferences.getString("jwt", null);
        if (jwtShare!=null){
            startActivity(new Intent(MainActivity.this, HomePageActivity.class));
        }

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String us= username.getText().toString().trim();
                String pass= password.getText().toString().trim();
                User user= new User(us, pass);
                ApiController.apiService.login(user).enqueue(new Callback<ResponseLogin>() {
                    @Override
                    public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                        if (response.isSuccessful()){
                            String jwt= response.body().getData().getAccess_token();
                            editor= sharedPreferences.edit();
//                            String jwt= response.body().getJwt();
                            editor.putString("jwt", jwt);
                            editor.commit();
                            startActivity(new Intent(MainActivity.this, HomePageActivity.class));
                            Log.d("jwt", "jwt login: "+ jwt);
                        }else {
                            Toast.makeText(MainActivity.this, "TK hoặc MK sai", Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseLogin> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Lỗi: "+ t.getMessage(), Toast.LENGTH_SHORT).show();
                        Log.d("er", "onFailure: "+t.getMessage());
                    }
                });
//                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
//                    Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(MainActivity.this, HomePageActivity.class);
//                    startActivity(intent);
//                }else
//                    Toast.makeText(MainActivity.this, "Tên đăng nhập hoặc mật khẩu không đúng", Toast.LENGTH_SHORT).show();


            }
        });

        changePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChangePasswordActivity.class);
                startActivity(intent);
            }
        });
    }
}