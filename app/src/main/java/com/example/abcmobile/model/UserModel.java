package com.example.abcmobile.model;

public class UserModel {
    private int Id, StatusKawin;
    private String Nama, TTL, JenisKelamin, Alamat, Agama, Pekerjaan, Kewarganegaraan, NoHP;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getStatusKawin() {
        return StatusKawin;
    }

    public void setStatusKawin(int statusKawin) {
        StatusKawin = statusKawin;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getTTL() {
        return TTL;
    }

    public void setTTL(String TTL) {
        this.TTL = TTL;
    }

    public String getJenisKelamin() {
        return JenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        JenisKelamin = jenisKelamin;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String alamat) {
        Alamat = alamat;
    }

    public String getAgama() {
        return Agama;
    }

    public void setAgama(String agama) {
        Agama = agama;
    }

    public String getPekerjaan() {
        return Pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        Pekerjaan = pekerjaan;
    }

    public String getKewarganegaraan() {
        return Kewarganegaraan;
    }

    public void setKewarganegaraan(String kewarganegaraan) {
        Kewarganegaraan = kewarganegaraan;
    }

    public String getNoHP() {
        return NoHP;
    }

    public void setNoHP(String noHP) {
        NoHP = noHP;
    }
}
