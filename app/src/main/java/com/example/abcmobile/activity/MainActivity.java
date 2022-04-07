package com.example.abcmobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.abcmobile.R;
import com.example.abcmobile.adapter.TransferAdapter;
import com.example.abcmobile.api.ApiRequestData;
import com.example.abcmobile.model.AccountResponse;
import com.example.abcmobile.api.RetroFitClient;
import com.example.abcmobile.model.TransferModel;
import com.example.abcmobile.model.TransferResponse;
//import kotlinx.android.synthetic.main.list_transaksi.*;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button btn_mabc;
    private Button btn_rek_baru;
    private Button btn_ganti_kode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_mabc = findViewById(R.id.mabc);
        btn_rek_baru = findViewById(R.id.bukarekeningbaru);
        btn_ganti_kode = findViewById(R.id.gantikodekases);

        btn_mabc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Login.class));
            }
        });

        btn_rek_baru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, InsertRekening.class));
            }
        });

        btn_ganti_kode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, UpdateKodeAkses.class));
            }
        });
    }

}