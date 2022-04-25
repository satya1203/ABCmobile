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
import com.example.abcmobile.model.VirtualAccountResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateKodeAkses extends AppCompatActivity {

    private Button btn_ok;
    private Button btn_cancel;
    private String yKodeAkses, yNomorRekening, yKodeAksesCek;
    private EditText et_no_rek, et_kodeAksesBaru, et_kodeAksesBaruConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ganti_kode_akses);

        et_no_rek = findViewById(R.id.et_no_rek_update);
        et_kodeAksesBaru = findViewById(R.id.et_kode_akses_yang_baru);
        et_kodeAksesBaruConfirm = findViewById(R.id.et_konfirmasi_kode_akses_yang_baru);
        btn_ok = findViewById(R.id.btn_ok);
        btn_cancel = findViewById(R.id.btn_cancel);

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yNomorRekening = et_no_rek.getText().toString();
                yKodeAkses = et_kodeAksesBaru.getText().toString();
                yKodeAksesCek = et_kodeAksesBaruConfirm.getText().toString();
                if(yKodeAkses.equals(yKodeAksesCek)){
                    updateKodeAkses();
                } else {
                    Toast.makeText(UpdateKodeAkses.this, "Kode Akses Tidak Sesuai!" + " " + yKodeAkses + " " + yKodeAksesCek, Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UpdateKodeAkses.this, MainActivity.class));
            }
        });
    }

    private void updateKodeAkses(){
        ApiRequestData ardData = RetroFitClient.connectDB().create(ApiRequestData.class);
        Call<AccountResponse> updateData = ardData.updateKodeAkses(yNomorRekening,yKodeAkses);

        updateData.enqueue(new Callback<AccountResponse>() {
            @Override
            public void onResponse(Call<AccountResponse> call, Response<AccountResponse> response) {
                if(response.isSuccessful()) {
                    String message = response.body().getMessage();
                    Toast.makeText(UpdateKodeAkses.this, "Message : " + message, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(UpdateKodeAkses.this, "Update Kode Akses Gagal!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AccountResponse> call, Throwable t) {
                Toast.makeText(UpdateKodeAkses.this, "Cannot Connect to Server : "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }

}
