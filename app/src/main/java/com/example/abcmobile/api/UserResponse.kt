package com.example.abcmobile.api

data class UserResponse (
    //Sesuaikan dengan json
    val Id : Int,
    val Nama : String?,
    val TTL : String?,
    val JenisKelamin : String?,
    val Alamat : String?,
    val Agama : String?,
    val StatusKawin : Int,
    val Pekerjaan : String?,
    val Kewarganegaraan : String?,
    val NoHP : String?
    )