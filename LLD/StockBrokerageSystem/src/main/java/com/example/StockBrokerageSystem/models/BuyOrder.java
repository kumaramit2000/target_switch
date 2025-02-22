package com.example.StockBrokerageSystem.models;

import com.example.StockBrokerageSystem.enums.OrderStatus;

public class BuyOrder extends Order{

    public BuyOrder(String orderId, Account account, Stock stock, int quantity, double price){
        super(orderId, account, stock, quantity, price);
    }

    @Override
    public void execute() {
        double totalCost = quantity * price;
        if (account.getBalance() >= totalCost) {
            account.withdraw(totalCost);
            status = OrderStatus.EXECUTED;
        } else {
            status = OrderStatus.REJECTED;
            System.out.println("Insufficient funds to execute the buy order.");
        }
    }
}
