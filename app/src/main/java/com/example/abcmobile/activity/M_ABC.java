package com.example.abcmobile.activity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.abcmobile.R;

public class M_ABC extends AppCompatActivity {

    private ImageView m_transfer;
    private ImageView m_info;
    private ImageView m_payment;
    private ImageView exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m_abc);

        m_transfer = findViewById(R.id.iv_mtransfer);
        m_info = findViewById(R.id.iv_minfo);
        m_payment = findViewById(R.id.iv_mpayment);
        exit = findViewById(R.id.iv_exit);

        m_transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(M_ABC.this, InsertTransfer.class));
            }
        });

        m_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(M_ABC.this, M_Info.class));
            }
        });

        m_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(M_ABC.this, InsertVirtualAccount.class));
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(M_ABC.this, MainActivity.class));
            }
        });

    }

}
