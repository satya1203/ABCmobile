package com.example.abcmobile.activity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.abcmobile.R;
import com.example.abcmobile.adapter.TransferAdapter;
import com.example.abcmobile.api.ApiRequestData;
import com.example.abcmobile.api.RetroFitClient;
import com.example.abcmobile.model.AccountModel;
import com.example.abcmobile.model.AccountResponse;
import com.example.abcmobile.model.UserModel;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import cz.msebera.android.httpclient.Header;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InfoAccount extends AppCompatActivity {

    private String nokartu_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_saldo);

        nokartu_input = "123456789";
        getData();
    }

    public void getData() {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://192.168.1.8:8080/infoaccount/" + nokartu_input, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try{
                    JSONArray jsonArray = response.getJSONArray("data");
                    for(int i = 0; i < jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String norek = jsonObject.getString("nomor_rekening");
                        int saldo = jsonObject.getInt("saldo");
                        JSONObject jsonObject1 = jsonObject.getJSONObject("user");
                        String nama = jsonObject1.getString("nama");
                        setData(norek, saldo, nama);
                    }
                } catch (Exception e) {
                    Toast.makeText(InfoAccount.this, "Failed Catch Data! " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void setData(String norek, int saldo, String nama) {
        TextView tv_norek = findViewById(R.id.tv_norek);
        tv_norek.setText(norek);

        TextView tv_saldo = findViewById(R.id.tv_saldo);
        tv_saldo.setText("Rp. " + String.valueOf(saldo));

        TextView tv_nama = findViewById(R.id.tv_username);
        tv_nama.setText(nama);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

}
