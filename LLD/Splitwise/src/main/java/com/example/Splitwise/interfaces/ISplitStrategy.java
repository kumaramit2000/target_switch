package com.example.Splitwise.interfaces;

import com.example.Splitwise.models.Split;
import com.example.Splitwise.models.User;
import com.example.Splitwise.models.UserManager;

import java.util.List;

public interface ISplitStrategy {

    List<Split> split(User user, List<User> users, double amount, List<Double> subAmounts);

    default boolean verifySplit(List<Split> split, double amount, User user) {
        double amount2 = amount;
        for (Split subSplit : split) {
            amount -= subSplit.getAmount();
        }
        if (amount != 0) {
            System.out.println("Verify split failed.");
        }
        if (amount == 0) {
            UserManager.instance.updateUserBorrows(split, user, amount2);
        }
        return amount == 0;
    }
}
