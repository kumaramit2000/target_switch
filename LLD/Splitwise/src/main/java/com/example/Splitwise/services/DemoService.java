package com.example.Splitwise.services;

import com.example.Splitwise.enums.SplitType;
import com.example.Splitwise.models.Expense;
import com.example.Splitwise.models.ExpenseManager;
import com.example.Splitwise.models.User;
import com.example.Splitwise.models.UserManager;

import java.util.Arrays;
import java.util.List;

public class DemoService {
    ExpenseManager expenseManager = ExpenseManager.getInstance();
    UserManager userManager = UserManager.getInstance();
    User u1 = new User("vamsi", "vamsi@gmail.com", 0, 0, 0);
    User u2 = new User("krishna", "krishna@gmail.com", 0, 0, 0);
    User u3 = new User("jani", "jani@gmail.com", 0, 0, 0);

    userManager.addUser(u1);
    userManager.addUser(u2);
    userManager.addUser(u3);

    List<User> groupList = Arrays.asList(u1,u2,u3);
    List<User> users = userManager.getUsers().values().stream().toList();

    Expense result = expenseManager.addExpense("Red Biryani", u1, SplitType.EQUAL, users, 100, null);
    Expense result2 = expenseManager.addExpense("Groceries", u2, SplitType.PERCENTAGE, users, 200, Arrays.asList(0.3, 0.4, 0.3));
    List<Expense> result3 = expenseManager.showExpenses("1");

    System.out.println(result3);
    System.out.println(u1);
    System.out.println(u2);
    System.out.println(u3);
}
