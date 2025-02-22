package com.example.StockBrokerageSystem.models;

import com.example.StockBrokerageSystem.enums.OrderStatus;

public class SellOrder extends Order{

    public SellOrder(String orderId, Account account, Stock stock, int quantity, double price){
        super(orderId, account, stock, quantity, price);
    }

    @Override
    public void execute() {
        double totalAmount = quantity*price;
        account.deposit(totalAmount);
        status = OrderStatus.EXECUTED;
    }
}
