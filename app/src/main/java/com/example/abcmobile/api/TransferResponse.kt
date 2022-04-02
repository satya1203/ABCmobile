package com.example.abcmobile.api

data class TransferResponse (
    //Sesuaikan dengan json
    val Id : Int,
    val Jumlah : String?,
    val Berita : Int,
    val RekeningPengirim : String?,
    val RekeningPenerima : String?,
    val Waktu : String?
)
