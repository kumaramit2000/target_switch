package com.example.Splitwise.models;

import com.example.Splitwise.enums.SplitType;

import java.util.List;

public class Expense {

    public List<Split> splits;
    public int amount;
    public SplitType splitType;
    public String paidBy;
    public double netBalance;
    public String expenseName;

    public Expense(List<Split> splits, int amount, SplitType splitType, String paidBy, double netBalance, String expenseName) {
        this.splits = splits;
        this.amount = amount;
        this.splitType = splitType;
        this.paidBy = paidBy;
        this.netBalance = calculateNetBalance();
        this.expenseName = expenseName;
    }

    public double calculateNetBalance(){
        double totalAmountOfOthers = 0;
        for (Split split : splits) {
            if(split.user.equals(this.paidBy)) continue;
            totalAmountOfOthers += split.amount;
        }
        this.netBalance = totalAmountOfOthers;
        return totalAmountOfOthers;
    }

    public List<Split> getSplits() {
        return splits;
    }
}
