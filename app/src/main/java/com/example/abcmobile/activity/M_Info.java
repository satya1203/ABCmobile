package com.example.abcmobile.activity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.abcmobile.R;

public class M_Info extends AppCompatActivity {

    private TextView tv_info_saldo;
    private TextView tv_favorit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m_info);

        tv_info_saldo = findViewById(R.id.tv_info_saldo);
        tv_favorit = findViewById(R.id.tv_favorit);

        tv_info_saldo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(M_Info.this, InfoAccount.class));
            }
        });

        tv_favorit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(M_Info.this, Favorit.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }

}
