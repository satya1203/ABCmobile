package com.example.abcmobile.model;

import java.util.List;

public class AccountResponse {
    private String message;
    private List<AccountModel> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<AccountModel> getData() {
        return data;
    }

    public void setData(List<AccountModel> data) {
        this.data = data;
    }
}