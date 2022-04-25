package com.example.abcmobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.abcmobile.R;
import com.example.abcmobile.api.ApiRequestData;
import com.example.abcmobile.api.RetroFitClient;
import com.example.abcmobile.model.VirtualAccountResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertVirtualAccount extends AppCompatActivity {

    private EditText et_rek_pengirim, et_rek_penerima;
    private Button btn_send;
    private String rek_pengirim, rek_penerima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m_payment);

        et_rek_pengirim = findViewById(R.id.et_rek_pengirim);
        et_rek_penerima = findViewById(R.id.et_rek_penerima);
        btn_send = findViewById(R.id.btn_send_VA);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(et_rek_pengirim.getText().toString()) || TextUtils.isEmpty(et_rek_penerima.getText().toString())){
                    Toast.makeText(InsertVirtualAccount.this, "Rek.Pengirim / Rek.Penerima Required!", Toast.LENGTH_LONG).show();
                } else {
                    rek_pengirim = et_rek_pengirim.getText().toString();
                    rek_penerima = et_rek_penerima.getText().toString();
                    createData();
                }
                //startActivity(new Intent(InsertVirtualAccount.this, Konfirmasi.class));
            }
        });
    }

    public void createData() {
        ApiRequestData ardData = RetroFitClient.connectDB().create(ApiRequestData.class);
        Call<VirtualAccountResponse> simpanData = ardData.insertVirtualAccount(rek_penerima,rek_pengirim);

        simpanData.enqueue(new Callback<VirtualAccountResponse>() {
            @Override
            public void onResponse(Call<VirtualAccountResponse> call, Response<VirtualAccountResponse> response) {
                String message = response.body().getMessage();

                Toast.makeText(InsertVirtualAccount.this, "Message : "+message, Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<VirtualAccountResponse> call, Throwable t) {
                Toast.makeText(InsertVirtualAccount.this, "Cannot Connect to Server : "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }

}
