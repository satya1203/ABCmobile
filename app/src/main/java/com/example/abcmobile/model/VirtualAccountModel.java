package com.example.abcmobile.model;

import java.sql.Time;

public class VirtualAccountModel {
    private int Id, Tagihan, Status;
    private TransferModel transfer;
    private String NoVA;
    private Time Batas, Waktu;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public TransferModel getTransfer() {
        return transfer;
    }

    public void setTransfer(TransferModel transfer) {
        this.transfer = transfer;
    }

    public int getTagihan() {
        return Tagihan;
    }

    public void setTagihan(int tagihan) {
        Tagihan = tagihan;
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

    public Time getBatas() {
        return Batas;
    }

    public void setBatas(Time batas) {
        Batas = batas;
    }

    public Time getWaktu() {
        return Waktu;
    }

    public void setWaktu(Time waktu) {
        Waktu = waktu;
    }
}
