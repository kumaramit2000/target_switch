package com.example.StockBrokerageSystem.models;

public class User {
    private final String  userId;
    private final String  name;
    private final String  email;
    private final String phoneNo;

    public User(String userId, String name, String email, String phoneNo) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }
}
