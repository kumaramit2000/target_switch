package com.example.StockBrokerageSystem.models;

public class Account {
    public final String accountId;
    private String password;
    private Location address;
    public double balance;
    public User user;
    public Portfolio portfolio;

    public Account(String accountId, double balance, User user) {
        this.accountId = accountId;
        this.balance = balance;
        this.user = user;
        this.portfolio = new Portfolio(this);
    }

    // deposit
    public synchronized void deposit(double amount){
        balance+=amount;
    }

    // withdraw
    public synchronized void withdraw(double amount){
        if(amount>balance){
            System.out.println("Insufficient funds in the account.");
        } else {
            balance-=amount;
        }
    }

    public String getAccountId() {
        return accountId;
    }

    public String getPassword() {
        return password;
    }

    public Location getAddress() {
        return address;
    }

    public double getBalance() {
        return balance;
    }

    public User getUser() {
        return user;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }
}
