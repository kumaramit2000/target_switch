package com.example.Splitwise.models;

import com.example.Splitwise.enums.SplitType;
import com.example.Splitwise.interfaces.ISplitStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ExpenseManager {

    private static volatile ExpenseManager instance;
    private static final Object lockObj = new Object();
    private Map<String, List<Expense>> expenses;

    private ExpenseManager() {
        this.expenses = new ConcurrentHashMap<>();
    }

    public static ExpenseManager getInstance() {
        if (instance == null) {
            synchronized (ExpenseManager.class) {
                if (instance == null) {
                    instance = new ExpenseManager();
                }
            }
        }
        return instance;
    }

    public Expense addExpense(String expenseName, User user, SplitType splitType, List<User> users, int amount, List<Double> subAmount) {
        ISplitStrategy splitStrategy = SplitStrategyFactory.createStrategy(splitType);
        List<Split> splits = splitStrategy.split(user, users, amount, subAmount);
        expenses.putIfAbsent(user.getUserId(), new ArrayList<>());
        Expense expense = new Expense(splits, amount, splitType, user.getUserId(), amount, expenseName);
        expenses.get(user.getUserId()).add(expense);
        return expense;
    }

    public List<Expense> showExpenses(String userId) {
        List<Expense> result = new ArrayList<>();
        for (List<Expense> userExpense : expenses.values()) {
            for (Expense expense : userExpense) {
                if (expense.getSplits().stream().anyMatch(split -> split.getUser().equals(userId))) {
                    result.add(expense);
                }
            }
        }
        return result;
    }
}
