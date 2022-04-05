package com.example.abcmobile.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.abcmobile.R

class MInfo : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.m_info)

        val btnInfoSaldo: Button = findViewById(R.id.btn_info_saldo)
        btnInfoSaldo.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.btn_info_saldo ->{
                val moveIntent = Intent(this@MInfo,InfoSaldo:: class.java)
                startActivity(moveIntent)
            }
        }
    }
}