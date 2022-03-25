package com.example.abcmobile

import java.util.*

data class RekeningModel (
    var nomor_rekening: String = "",
    var saldo: Double = getAutoSaldo()
){
    companion object {
        fun getAutoSaldo(): Double {
            val random = Random()
            return random.nextDouble()
        }
    }

}