package com.example.abcmobile.api

data class VirtualAccountResponse (
        //Sesuaikan dengan json
        val Id : Int,
        val Transfer : String?,
        val NoVA : String?,
        val Tagihan : String?,
        val Batas : String?,
        val Waktu : String?,
        val Status : Int
)