package com.example.Splitwise.models;

import java.util.UUID;

public class User {

    public String userId;
    public String name;
    public String email;
    public double totalBorrows;
    public double totalPays;
    public double net;

    public User(String name, String email, double totalBorrows, double totalPays, double net) {
        this.userId = generateUUID();
        this.name = name;
        this.email = email;
        this.totalBorrows = 0;
        this.totalPays = 0;
        this.net = 0;
    }

    private String generateUUID(){
        return UUID.randomUUID().toString().replace("-", "").substring(0,8);
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

    public double getTotalBorrows() {
        return totalBorrows;
    }

    public double getTotalPays() {
        return totalPays;
    }

    public double getNet() {
        return net;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTotalBorrows(double totalBorrows) {
        this.totalBorrows = totalBorrows;
    }

    public void setTotalPays(double totalPays) {
        this.totalPays = totalPays;
    }

    public void setNet(double net) {
        this.net = net;
    }
}
