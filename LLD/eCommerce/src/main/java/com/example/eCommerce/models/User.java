package com.example.eCommerce.models;

import com.example.eCommerce.enums.AccountStatus;

import java.util.List;

public class User {
    private String userId;
    private String userName;
    private String password;
    private AccountStatus status;
    private String name;
    private String shippingAddress;
    private String email;
    private String phone;

    public String getUserId(){
        return userId;
    }
}
