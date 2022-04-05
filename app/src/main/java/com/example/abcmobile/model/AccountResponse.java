package com.example.abcmobile.model;

import java.util.List;

public class AccountResponse {
    private String message;
    private List<TransferModel> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<TransferModel> getData() {
        return data;
    }

    public void setData(List<TransferModel> data) {
        this.data = data;
    }
}