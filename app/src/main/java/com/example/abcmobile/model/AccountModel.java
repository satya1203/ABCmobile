package com.example.abcmobile.model;

public class AccountModel {
    private int Id, Saldo;
    private String NomorKartu, NomorRekening, KodeAkses;
    private UserModel user;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getSaldo() {
        return Saldo;
    }

    public void setSaldo(int saldo) {
        Saldo = saldo;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public String getNomorKartu() {
        return NomorKartu;
    }

    public void setNomorKartu(String nomorKartu) {
        NomorKartu = nomorKartu;
    }

    public String getNomorRekening() {
        return NomorRekening;
    }

    public void setNomorRekening(String nomorRekening) {
        NomorRekening = nomorRekening;
    }

    public String getKodeAkses() {
        return KodeAkses;
    }

    public void setKodeAkses(String kodeAkses) {
        KodeAkses = kodeAkses;
    }
}
