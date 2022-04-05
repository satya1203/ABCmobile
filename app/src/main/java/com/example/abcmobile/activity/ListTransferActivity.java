package com.example.abcmobile.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.abcmobile.R;
import com.example.abcmobile.adapter.TransferAdapter;
import com.example.abcmobile.api.ApiRequestData;
import com.example.abcmobile.api.RetroFitClient;
import com.example.abcmobile.model.TransferModel;
import com.example.abcmobile.model.TransferResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListTransferActivity extends AppCompatActivity {
    private RecyclerView rvData;
    private RecyclerView.Adapter adData;
    private RecyclerView.LayoutManager lmData;
    private List<TransferModel> listTransfer = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_transaksi);

        rvData = findViewById(R.id.rvTransfer);
        lmData = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvData.setLayoutManager(lmData);

        retrieveData();
    }

    public void retrieveData() {
        ApiRequestData ardData = RetroFitClient.connectDB().create(ApiRequestData.class);
        Call<TransferResponse> tampilData = ardData.getListTransfer();

        tampilData.enqueue(new Callback<TransferResponse>() {
            @Override
            public void onResponse(Call<TransferResponse> call, Response<TransferResponse> response) {
                String message = response.body().getMessage();

                Toast.makeText(ListTransferActivity.this, "Message : "+message, Toast.LENGTH_SHORT).show();

                listTransfer = response.body().getData();

                adData = new TransferAdapter(ListTransferActivity.this, listTransfer);
                rvData.setAdapter(adData);
                adData.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<TransferResponse> call, Throwable t) {
                Toast.makeText(ListTransferActivity.this, "Server Failed" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
