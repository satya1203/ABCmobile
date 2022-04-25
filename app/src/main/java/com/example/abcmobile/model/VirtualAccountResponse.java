package com.example.abcmobile.model;

import java.util.List;

public class VirtualAccountResponse {
    private String message;
    private List<VirtualAccountModel> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<VirtualAccountModel> getData() {
        return data;
    }

    public void setData(List<VirtualAccountModel> data) {
        this.data = data;
    }
}