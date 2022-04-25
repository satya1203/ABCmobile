package com.example.abcmobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.abcmobile.R;
import com.example.abcmobile.api.ApiRequestData;
import com.example.abcmobile.api.RetroFitClient;
import com.example.abcmobile.model.AccountResponse;
import com.example.abcmobile.model.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertRekening extends AppCompatActivity {

    private EditText et_nama, et_ttl, et_jk, et_alamat, et_status, et_pekerjaan, et_kewarganegaraan, et_nohp, et_kodeakses, et_agama;
    private Button btn_send;
    private String nama, ttl, jk, alamat, pekerjaan, kewarganegaraan, nohp, kodeakses, agama;
    private Integer status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buka_rekening_baru);

        et_nama = findViewById(R.id.et_nama);
        et_ttl = findViewById(R.id.et_ttl);
        et_jk = findViewById(R.id.et_jk);
        et_alamat = findViewById(R.id.et_alamat);
        et_status = findViewById(R.id.et_status_kawin);
        et_pekerjaan = findViewById(R.id.et_pekerjaan);
        et_kewarganegaraan = findViewById(R.id.et_kewarganegaraan);
        et_nohp = findViewById(R.id.et_nohp);
        et_kodeakses = findViewById(R.id.et_kode_akses_daftar);
        et_agama = findViewById(R.id.et_agama);
        btn_send = findViewById(R.id.btn_send_rekening_baru);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = et_nama.getText().toString();
                ttl = et_ttl.getText().toString();
                jk = et_jk.getText().toString();
                alamat = et_alamat.getText().toString();
                status = Integer.valueOf(et_status.getText().toString());
                pekerjaan = et_pekerjaan.getText().toString();
                kewarganegaraan = et_kewarganegaraan.getText().toString();
                nohp = et_nohp.getText().toString();
                kodeakses = et_kodeakses.getText().toString();
                agama = et_agama.getText().toString();

                createData();
                //startActivity(new Intent(InsertRekening.this, Konfirmasi.class));
            }
        });
    }

    public void createData() {
        ApiRequestData ardData = RetroFitClient.connectDB().create(ApiRequestData.class);
        Call<UserResponse> simpanData = ardData.insertRekening(nama,ttl,jk,alamat,status,pekerjaan,kewarganegaraan,nohp,kodeakses,agama);

        simpanData.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                String message = response.body().getMessage();

                Toast.makeText(InsertRekening.this, "Message : "+message, Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(InsertRekening.this, "Cannot Connect to Server : "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }

}
