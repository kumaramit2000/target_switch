package com.example.Splitwise.models;

import com.example.Splitwise.enums.SplitType;

public class Split {

    public User user;
    public double amount;
    public SplitType splitType;

    public Split(User user, double amount, SplitType splitType) {
        this.user = user;
        this.amount = amount;
        this.splitType = splitType;
    }

    public User getUser() {
        return user;
    }

    public double getAmount() {
        return amount;
    }

    public SplitType getSplitType() {
        return splitType;
    }
}
