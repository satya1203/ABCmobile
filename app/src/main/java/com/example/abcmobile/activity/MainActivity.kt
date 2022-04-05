package com.example.abcmobile.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.abcmobile.R
import kotlinx.android.synthetic.main.activity_main.*

//import kotlinx.android.synthetic.main.list_transaksi.*;
class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMABC: Button = findViewById(R.id.mabc)
        val btnBukaRekeningBaru: Button = findViewById(R.id.bukarekeningbaru)
        val btnGantiKodeAkses: Button = findViewById(R.id.gantikodekases)
        btnMABC.setOnClickListener(this)
        btnBukaRekeningBaru.setOnClickListener(this)
        btnGantiKodeAkses.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.mabc ->{
                val moveIntent = Intent(this@MainActivity,MABC:: class.java)
                startActivity(moveIntent)
            }
            R.id.bukarekeningbaru ->{
                val moveIntent = Intent(this@MainActivity,BukaRekeningBaru:: class.java)
                startActivity(moveIntent)
            }
            R.id.gantikodekases ->{
                val moveIntent = Intent(this@MainActivity,GantiKodeAkses:: class.java)
                startActivity(moveIntent)
            }
        }
    }

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