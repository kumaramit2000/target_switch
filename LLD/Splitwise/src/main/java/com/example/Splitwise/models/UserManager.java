package com.example.Splitwise.models;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserManager {

    public static volatile UserManager instance;

    public Map<String, User> users;

    private UserManager(){
        users = new ConcurrentHashMap<>();
        // Private constructor prevents instantiation from other classes
    }

    public static synchronized UserManager getInstance(){
        if(instance==null){ // First check (without synchronization)
            synchronized (UserManager.class){
                if(instance==null){ // Second check (inside synchronized block)
                    instance = new UserManager();
                }
            }
        }
        return instance;
    }

    public User getUser(String userId){
        if(users.containsKey(userId)){
            return users.get(userId);
        } else {
            System.out.println("User not present!!!");
            return null;
        }
    }

    public double getNet(String userId){
        if(users.containsKey(userId)){
            return users.get(userId).getNet();
        } else {
            System.out.println("User not present!!!");
            return 0.00;
        }
    }

    public void addUser(User user){
        if(users.containsKey(user.getUserId())){
            System.out.println("User is already present!!!");
        } else {
            users.put(user.getUserId(), user);
            System.out.println("Added User with id : "+ user.getUserId());
        }
    }

    public boolean addPays(String userId, double amount){
         User user = users.get(userId);
         user.setTotalPays(user.getTotalPays()+amount);
         return true;
    }

    public boolean addBorrow(String userId, double amount){
        User user = users.get(userId);
        user.setTotalBorrows(user.getTotalBorrows()+amount);
        return true;
    }

    public void updateUserBorrows(List<Split> splits, User payer, double amount)
    {
        for (Split split : splits) {
            //he is the guy paid the amount.
            if (split.getUser().equals(payer)) {
                payer.setTotalPays(payer.getTotalPays() + amount);
                payer.setTotalBorrows(payer.getTotalBorrows() + split.getAmount());
            } else {
                payer.setTotalBorrows(payer.getTotalBorrows() + split.getAmount());
            }
            split.getUser().setNet(split.getUser().getTotalPays() - split.getUser().getTotalBorrows());
        }
    }

    public Map<String, User> getUsers() {
        return users;
    }
}
