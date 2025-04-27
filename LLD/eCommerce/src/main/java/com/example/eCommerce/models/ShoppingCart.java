package com.example.eCommerce.models;

import java.time.LocalDateTime;
import java.util.List;

public class ShoppingCart {
    private String cartId;
    private String userId; // optional if user is logged in
    private List<Item> items;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public void addItem(Product product, int quantity) { /* logic */ }
    public void removeItem(Product product) { /* logic */ }
    public void updateItem(Product product, int newQuantity) { /* logic */ }
    public double calculateTotalPrice() { /* logic */ return 0.0; }

    public List<Item> getItems(){
        return items;
    }
}
