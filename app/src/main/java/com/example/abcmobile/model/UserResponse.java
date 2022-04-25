package com.example.abcmobile.model;

import java.util.List;

public class UserResponse {
    private String message;
    private List<UserModel> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<UserModel> getData() {
        return data;
    }

    public void setData(List<UserModel> data) {
        this.data = data;
    }
}