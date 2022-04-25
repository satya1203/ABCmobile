package com.example.abcmobile.activity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.abcmobile.R;
import com.example.abcmobile.model_db_local.SQLiteHelper;

public class Favorit extends AppCompatActivity {

    EditText et_norek, et_alias;
    Button btn_view, btn_simpan, btn_edit, btn_delete;
    SQLiteHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorit);

        et_norek = findViewById(R.id.et_no_rek_favorit);
        et_alias = findViewById(R.id.et_alias);

        btn_view = findViewById(R.id.btn_view);
        btn_simpan = findViewById(R.id.btn_simpan);
        btn_edit = findViewById(R.id.btn_edit);
        btn_delete = findViewById(R.id.btn_delete);

        db = new SQLiteHelper(this);

        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String norek = et_norek.getText().toString();
                String alias = et_alias.getText().toString();

                Cursor res = db.getFavorites();

                Boolean cek = true;

                while(res.moveToNext()) {
                    if (res.getString(1).equals(norek)) {
                        Toast.makeText(Favorit.this, "Nomor Rekening Already Registered!", Toast.LENGTH_SHORT).show();
                        cek = false;
                    } else {
                        cek = true;
                    }
                }

                if (cek == true) {
                    db.insertFavorites(norek, alias);
                    Toast.makeText(Favorit.this, "Insert New Favorite Succeed!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Favorit.this, "Failed Insert New Favorite!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = db.getFavorites();
                if(res.getCount() == 0){
                    Toast.makeText(Favorit.this, "No Entry Existed!", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Rekening : " + res.getString(1) + "\n");
                    buffer.append("Alias : " + res.getString(2) + "\n");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(Favorit.this);
                builder.setCancelable(true);
                builder.setTitle("List Favorit");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });

        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String norek = et_norek.getText().toString();
                String alias = et_alias.getText().toString();

                Boolean cek = db.updateFavorites(norek, alias);
                if(cek) {
                    Toast.makeText(Favorit.this, "Update Favorite Succeed!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Favorit.this, "Failed Update Favorite!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String norek = et_norek.getText().toString();

                Boolean cek = db.deleteFavorites(norek);
                if(cek) {
                    Toast.makeText(Favorit.this, "Delete Favorite Succeed!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Favorit.this, "Failed Delete Favorite!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(Favorit.this, M_Info.class));
    }
}