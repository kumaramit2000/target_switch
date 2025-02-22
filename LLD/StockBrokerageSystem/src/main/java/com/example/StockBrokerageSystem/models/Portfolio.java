package com.example.StockBrokerageSystem.models;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Portfolio {

    public Account account;
    private final Map<String, Integer> holdings;

    public Portfolio(Account account) {
        this.account = account;
        this.holdings = new ConcurrentHashMap<>();
    }

    // add stock
    public synchronized void addStock(Stock stock, int quantity){
        String symbol = stock.getStockSymbol();
        if(holdings.containsKey(symbol)){
            int currQuantity = holdings.get(symbol);
            currQuantity+=quantity;
            holdings.put(symbol,currQuantity);
        } else {
            holdings.put(symbol,quantity);
        }
    }

    //remove stock
    public synchronized void removeStock(Stock stock, int quantity) {
        String symbol = stock.getStockSymbol();
        if (holdings.containsKey(symbol)) {
            int currentQuantity = holdings.get(symbol);
            if (currentQuantity > quantity) {
                holdings.put(symbol, currentQuantity - quantity);
            } else if (currentQuantity == quantity) {
                holdings.remove(symbol);
            } else {
                System.out.println("Insufficient stock quantity in the portfolio.");
            }
        } else {
            System.out.println("Stock not found in the portfolio.");
        }
    }
}
