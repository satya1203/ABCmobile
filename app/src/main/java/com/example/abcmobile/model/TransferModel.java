package com.example.abcmobile.model;

public class TransferModel {
    private int Id;
    private String Jumlah, Berita, RekeningPengirim, RekeningPenerima, Waktu;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getJumlah() {
        return Jumlah;
    }

    public void setJumlah(String jumlah) {
        Jumlah = jumlah;
    }

    public String getBerita() {
        return Berita;
    }

    public void setBerita(String berita) {
        Berita = berita;
    }

    public String getRekeningPengirim() {
        return RekeningPengirim;
    }

    public void setRekeningPengirim(String rekeningPengirim) {
        RekeningPengirim = rekeningPengirim;
    }

    public String getRekeningPenerima() {
        return RekeningPenerima;
    }

    public void setRekeningPenerima(String rekeningPenerima) {
        RekeningPenerima = rekeningPenerima;
    }

    public String getWaktu() {
        return Waktu;
    }

    public void setWaktu(String waktu) {
        Waktu = waktu;
    }
}
