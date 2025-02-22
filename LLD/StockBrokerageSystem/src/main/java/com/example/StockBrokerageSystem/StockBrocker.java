package com.example.StockBrokerageSystem;

import com.example.StockBrokerageSystem.models.Account;
import com.example.StockBrokerageSystem.models.Order;
import com.example.StockBrokerageSystem.models.Stock;
import com.example.StockBrokerageSystem.models.User;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class StockBrocker {
    private static StockBrocker instance;
    private Map<String, Account> accounts;
    private Map<String, Stock> stocks;
    private Queue<Order> orderQueue;
    private static final AtomicInteger counter = new AtomicInteger(10000000); // Start from 8-digit value

    private void StockBroker() {
        accounts = new ConcurrentHashMap<>();
        stocks = new ConcurrentHashMap<>();
        orderQueue = new ConcurrentLinkedQueue<>();
    }

    public static synchronized StockBrocker getInstance(){
        if(instance==null){
            instance = new StockBrocker();
        }
        return instance;
    }

    //create account
    public void createAccount(User user, double initialBalance) {
        String accountId = generateAccountId();
        Account account = new Account(accountId, initialBalance, user);
        accounts.put(accountId, account);
    }

    private String generateAccountId() {
        return String.valueOf(counter.getAndIncrement());
    }

    public Account getAccount(String accountId) {
        return accounts.get(accountId);
    }

    //add stock
    public void addStock(Stock stock) {
        stocks.put(stock.getStockSymbol(), stock);
    }

    //place order
    public void placeOrder(Order order) {
        orderQueue.offer(order);
        processOrders();
    }

    private void processOrders() {
        while (!orderQueue.isEmpty()) {
            Order order = orderQueue.poll();
            try {
                order.execute();
            } catch (Exception ex) {
                // Handle exception and notify user
                System.out.println("Order failed: " + ex.getMessage());
            }
        }
    }

}
