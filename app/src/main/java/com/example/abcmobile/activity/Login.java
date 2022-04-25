package com.example.abcmobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.abcmobile.R;
import com.example.abcmobile.api.ApiRequestData;
import com.example.abcmobile.api.RetroFitClient;
import com.example.abcmobile.model.AccountModel;
import com.example.abcmobile.model.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    private EditText et_nokartu, et_kodeakses;
    private Button btn_login, btn_cancel;
    private String nokartu, kodeakses;
    //AccountModel am = new AccountModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_kode_akses);

        et_nokartu = findViewById(R.id.et_input_nokartu);
        et_kodeakses = findViewById(R.id.et_input_kodeakses);
        btn_cancel = findViewById(R.id.btn_cancel_login);
        btn_login = findViewById(R.id.btn_login);

        //am.setNomorKartu(et_nokartu.getText().toString());

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, MainActivity.class));
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(et_nokartu.getText().toString()) || TextUtils.isEmpty(et_kodeakses.getText().toString())){
                    Toast.makeText(Login.this, "Nomor Kartu / Kode Akses Required!", Toast.LENGTH_LONG).show();
                } else {
                    nokartu = et_nokartu.getText().toString();
                    kodeakses = et_kodeakses.getText().toString();

                    retrieveData();
                }
            }
        });
    }

    public void retrieveData() {
        ApiRequestData ardData = RetroFitClient.connectDB().create(ApiRequestData.class);
        Call<UserResponse> tampilData = ardData.login(nokartu, kodeakses);

        tampilData.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if(response.isSuccessful()){
                    String message = response.body().getMessage();
                    Toast.makeText(Login.this, "Message : "+message, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Login.this, BottomNav.class));
                } else {
                    Toast.makeText(Login.this, "Nomor Kartu / Kode Akses Salah!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(Login.this, "Server Failed" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }

}
