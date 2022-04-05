package com.example.abcmobile.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
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

    //private val list = ArrayList<AccountResponse>()

    //showInfoAccount()
    //insertTransfer()
    //updateKodeAkses()

    /*
    private fun updateKodeAkses() {
        RetroFitClient.instance.updateKodeAkses(
            "987654",
            "yellow"
        ).enqueue(object : Callback<AccountResponse>{
            override fun onResponse(
                call: Call<AccountResponse>,
                response: Response<AccountResponse>
            ) {
                tvTransferResponse.text = response.code().toString()
                val responseText = "Response Code: ${response.code()}\n" +
                        "Nomor Kartu: ${response.body()?.NomorKartu}\n" +
                        "Kode Akses: ${response.body()?.KodeAkses}"
                tvTransferResponse.text = responseText
            }

            override fun onFailure(call: Call<AccountResponse>, t: Throwable) {
                tvTransferResponse.text = t.message
            }

        })
    }

    private fun insertTransfer() {
        RetroFitClient.instance.insertTransfer(
            1,
            "100000",
            "Uang Makan",
            "101010",
            "111111",
            "16:23"
        ).enqueue(object  : Callback<TransferResponse>{
            override fun onResponse(
                call: Call<TransferResponse>,
                response: Response<TransferResponse>
            ) {
                val responseText = "Response Code: ${response.code()}\n" +
                        "Id: ${response.body()?.Id}\n" +
                        "Jumlah: ${response.body()?.Jumlah}\n" +
                        "Berita: ${response.body()?.Berita}\n" +
                        "Rekening Pengirim: ${response.body()?.RekeningPengirim}\n" +
                        "Rekening Penerima: ${response.body()?.RekeningPenerima}\n" +
                        "Waktu: ${response.body()?.Waktu}"
                tvTransferResponse.text = responseText
            }

            override fun onFailure(call: Call<TransferResponse>, t: Throwable) {
                tvTransferResponse.text = t.message
            }

        })
    }

    private fun showInfoAccount() {
        rvTransfer.setHasFixedSize(true)
        rvTransfer.layoutManager = LinearLayoutManager(this)

        RetroFitClient.instance.getInfoTransaksi().enqueue(object: Callback<ArrayList<AccountResponse>>{
            override fun onResponse(
                call: Call<ArrayList<AccountResponse>>,
                response: Response<ArrayList<AccountResponse>>
            ) {
                val responseCode = response.code().toString()
                tvTransferResponse.text = responseCode
                response.body()?.let { list.addAll(it)}
                val adapter = AccountAdapter(list)
                rvTransfer.adapter = adapter
            }

            override fun onFailure(call: Call<ArrayList<AccountResponse>>, t: Throwable) {
                tvTransferResponse.text = t.message
            }

        })
    }
    */
}