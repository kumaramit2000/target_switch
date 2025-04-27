package com.example.eCommerce.models;

import java.util.List;

public class Product {
    private String productId;
    private ProductCategory category;
    private String name;
    private String description;
    private double price;
    private User seller;
    private int availableQuantity; // how many are in stock
    private List<String> images;

    public int getAvailableQuantity(){
        return availableQuantity;
    }

    public boolean updatePrice(double newPrice){
        price = newPrice;
        return true;
    }
    public synchronized void updateQuantity(int quantity) {
        this.availableQuantity += quantity;
    }

    public synchronized boolean isAvailable(int quantity) {
        return this.availableQuantity >= quantity;
    }

    public double getPrice(){
        return price;
    }
}
