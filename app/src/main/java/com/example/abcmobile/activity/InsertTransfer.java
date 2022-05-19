package com.example.abcmobile.activity;

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
import com.example.abcmobile.model.AccountModel;
import com.example.abcmobile.model.TransferResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertTransfer extends AppCompatActivity {

    private EditText et_jumlah, et_berita, et_rek_penerima;
    private Button btn_send;
    private String berita, rek_penerima, rek_pengirim;
    private Integer jumlah;
    private String rek_penerima_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m_transfer);

        rek_penerima_input = "987654321";
        et_jumlah = findViewById(R.id.et_jumlah);
        et_berita = findViewById(R.id.et_berita);
        et_rek_penerima = findViewById(R.id.et_rek_tujuan);
        btn_send = findViewById(R.id.btn_send_transfer);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(et_jumlah.getText().toString()) || TextUtils.isEmpty(et_rek_penerima.getText().toString())){
                    Toast.makeText(InsertTransfer.this, "Jumlah / Rek.Penerima Required!", Toast.LENGTH_LONG).show();
                } else {
                    jumlah = Integer.valueOf(et_jumlah.getText().toString());
                    berita = et_berita.getText().toString();
                    rek_penerima = et_rek_penerima.getText().toString();
                    rek_pengirim = rek_penerima_input;
                    createData();
                }
                //startActivity(new Intent(InsertTransfer.this, Konfirmasi.class));
            }
        });
    }

    public void createData() {
        ApiRequestData ardData = RetroFitClient.connectDB().create(ApiRequestData.class);
        Call<TransferResponse> simpanData = ardData.insertTransfer(jumlah,berita,rek_penerima,rek_pengirim);

        simpanData.enqueue(new Callback<TransferResponse>() {
            @Override
            public void onResponse(Call<TransferResponse> call, Response<TransferResponse> response) {
                String message = response.body().getMessage();

                Toast.makeText(InsertTransfer.this, "Message : "+message, Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<TransferResponse> call, Throwable t) {
                Toast.makeText(InsertTransfer.this, "Cannot Connect to Server : "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }

}
