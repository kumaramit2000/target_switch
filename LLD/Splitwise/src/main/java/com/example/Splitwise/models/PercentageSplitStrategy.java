package com.example.Splitwise.models;

import com.example.Splitwise.enums.SplitType;
import com.example.Splitwise.interfaces.ISplitStrategy;

import java.util.ArrayList;
import java.util.List;

public class PercentageSplitStrategy implements ISplitStrategy {

    @Override
    public List<Split> split(User user, List<User> users, double amount, List<Double> subAmounts) {
        double curTotal = 0;
        List<Split> splits = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            double curAmount = Math.round(amount * subAmounts.get(i) * 100.0) / 100.0;
            curTotal += curAmount;
            Split split = new Split(users.get(i), (i == users.size() - 1) ? (amount - curTotal + curAmount) : curAmount, SplitType.PERCENTAGE);
            splits.add(split);
        }
        verifySplit(splits, amount, user);
        return splits;
    }
}
