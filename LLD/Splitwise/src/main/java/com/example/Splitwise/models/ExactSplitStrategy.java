package com.example.Splitwise.models;

import com.example.Splitwise.enums.SplitType;
import com.example.Splitwise.interfaces.ISplitStrategy;

import java.util.ArrayList;
import java.util.List;

public class ExactSplitStrategy implements ISplitStrategy {

    @Override
    public List<Split> split(User user, List<User> users, double amount, List<Double> subAmounts) {
        List<Split> splits = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            splits.add(new Split(users.get(i), Math.round(subAmounts.get(i) * 100.0) / 100.0, SplitType.EXACT));
        }
        verifySplit(splits, amount, user);
        return splits;
    }
}
