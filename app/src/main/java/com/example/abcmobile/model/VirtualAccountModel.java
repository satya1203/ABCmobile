package com.example.abcmobile.model;

public class VirtualAccountModel {
    private int Id, Transfer, Status;
    private String NoVA, Tagihan, Batas, Waktu;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getTransfer() {
        return Transfer;
    }

    public void setTransfer(int transfer) {
        Transfer = transfer;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getNoVA() {
        return NoVA;
    }

    public void setNoVA(String noVA) {
        NoVA = noVA;
    }

    public String getTagihan() {
        return Tagihan;
    }

    public void setTagihan(String tagihan) {
        Tagihan = tagihan;
    }

    public String getBatas() {
        return Batas;
    }

    public void setBatas(String batas) {
        Batas = batas;
    }

    public String getWaktu() {
        return Waktu;
    }

    public void setWaktu(String waktu) {
        Waktu = waktu;
    }
}
