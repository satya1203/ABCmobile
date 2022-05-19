package com.example.abcmobile.api;

import com.example.abcmobile.model.AccountResponse;
import com.example.abcmobile.model.TransferResponse;
import com.example.abcmobile.model.UserResponse;
import com.example.abcmobile.model.VirtualAccountResponse;

import retrofit2.Call;
import retrofit2.http.*;

public interface ApiRequestData {
    @GET("/listTransfer")
    Call<TransferResponse> getListTransfer();

    @GET("/infoaccount/{nomor_kartu}")
    Call<AccountResponse> getAccountInfo(
       @Path("nomor_kartu") String NomorKartu
    );

    @FormUrlEncoded
    @POST("/login")
    Call<UserResponse> login(
       @Field("nomor_kartu") String NomorKartu,
       @Field("kode_akses") String KodeAkses
    );

    @GET("/logout")
    Call<UserResponse> logout();

    @FormUrlEncoded
    @POST("/insertTransfer")
    Call<TransferResponse> insertTransfer(
        @Field("jumlah") Integer Jumlah,
        @Field("berita") String Berita,
        @Field("rekening_penerima") String RekeningPenerima,
        @Field("rekening_pengirim") String RekeningPengirim
    );

    @FormUrlEncoded
    @POST("/virtualaccount")
    Call<VirtualAccountResponse> insertVirtualAccount(
        @Field("rekening_penerima") String RekeningPenerima,
        @Field("rekening_pengirim") String RekeningPengirim
    );

    @FormUrlEncoded
    @POST("/rekeningbaru")
    Call<UserResponse> insertRekening(
        @Field("nama") String Nama,
        @Field("ttl") String Ttl,
        @Field("jenis_kelamin") String Jk,
        @Field("alamat") String Alamat,
        @Field("status_perkawinan") Integer StatusKawin,
        @Field("pekerjaan") String Pekerjaan,
        @Field("kewarganegaraan") String Kewarganegaraan,
        @Field("no_hp") String NomorHP,
        @Field("kode_akses") String KodeAkses,
        @Field("agama") String Agama
    );

    @FormUrlEncoded
    @POST("/gantikodeakses")
    Call<AccountResponse> updateKodeAkses(
       @Field("nomor_rekening") String NomorRekening,
       @Field("kode_akses") String KodeAkses
    );

}