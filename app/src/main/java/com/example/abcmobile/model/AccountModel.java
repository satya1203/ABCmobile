package com.example.abcmobile.model;

public class AccountModel {
    private int Id, User, Saldo, KodeAkses;
    private String NomorKartu, NomorRekening;

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

    public int getKodeAkses() {
        return KodeAkses;
    }

    public void setKodeAkses(int kodeAkses) {
        KodeAkses = kodeAkses;
    }

    public int getUser() {
        return User;
    }

    public void setUser(int user) {
        User = user;
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
}
