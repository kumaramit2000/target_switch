package com.example.Splitwise.models;

import com.example.Splitwise.enums.SplitType;
import com.example.Splitwise.interfaces.ISplitStrategy;

import java.util.ArrayList;
import java.util.List;

public class EqualSplitStrategy implements ISplitStrategy {


    @Override
    public List<Split> split(User user, List<User> users, double amount, List<Double> subAmounts) {
        int totalUsers = users.size();
        double eachShare = Math.round(amount / totalUsers * 100.0) / 100.0;
        double tailShare = amount - (eachShare * (totalUsers - 1));
        List<Split> splits = new ArrayList<>();

        for (int i = 0; i < totalUsers; i++) {
            Split split = new Split(users.get(i), (i == totalUsers - 1) ? tailShare : eachShare, SplitType.EQUAL);
            splits.add(split);
        }
        return verifySplit(splits, amount, user) ? splits : null;
    }
}
