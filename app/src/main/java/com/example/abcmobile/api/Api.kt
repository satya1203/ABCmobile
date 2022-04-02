package com.example.abcmobile.api

import retrofit2.Call
import retrofit2.http.*

interface Api {
    @GET("/infoaccount")
    fun getInfoTransaksi(): Call<AccountResponse>

    @GET("/login")
    fun login(): Call<UserResponse>

    @FormUrlEncoded
    @POST("/transfer")
    fun insertTransfer(
        @Field("Id") Id: Int,
        @Field("Jumlah") Jumlah: String,
        @Field("Berita") Berita: String,
        @Field("RekeningPengirim") RekeningPengirim: String,
        @Field("RekeningPenerima") RekeningPenerima: String,
        @Field("Waktu") Waktu: String
    ): Call<TransferResponse>

    @FormUrlEncoded
    @POST("/virtualaccount")
    fun insertVirtualAccount(
        @Field("Id") Id: Int,
        @Field("Transfer") Transfer: String,
        @Field("NoVA") NoVA: String,
        @Field("Tagihan") Tagihan: String,
        @Field("Batas") Batas: String,
        @Field("Waktu") Waktu: String,
        @Field("Status") Status: Int
    ): Call<VirtualAccountResponse>

    @FormUrlEncoded
    @POST("/rekeningbaru")
    fun insertRekening(
        @Field("Id") Id: Int,
        @Field("User") User: String,
        @Field("Saldo") Saldo: Int,
        @Field("Nomor Kartu") NomorKartu: String,
        @Field("Nomor Rekening") NomorRekening: String,
        @Field("Kode Akses") KodeAkses: String
    ): Call<AccountResponse>

    @FormUrlEncoded
    @PUT("/gantikodeakses/{nomor_rekening}")
    fun updateKodeAkses(
        @Path("nomor_rekening") nomor_rekening: String?,
        @Field("kode_akses") kode_akses: String?
    ): Call<AccountResponse>

}