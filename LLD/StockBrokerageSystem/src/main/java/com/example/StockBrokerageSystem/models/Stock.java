package com.example.StockBrokerageSystem.models;

public class Stock {
    private final String stockSymbol;
    private final String name;
    private double price;

    public Stock(String stockSymbol, String name, double price) {
        this.stockSymbol = stockSymbol;
        this.name = name;
        this.price = price;
    }

    // updatePrice
    public synchronized void updatePrice(double newPrice) {
        price = newPrice;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
