package com.example.eCommerce.models;

import com.example.eCommerce.interfaces.Search;

import java.util.HashMap;
import java.util.List;

public class Catalog implements Search {
    HashMap<String, List<Product>> productNames;
    HashMap<String, List<Product>> productCategories;

    public List<Product> searchProductsByName(String name) {
        return productNames.get(name);
    }

    public List<Product> searchProductsByCategory(String category) {
        return productCategories.get(category);
    }

    public Product getInfo(String productId) {
        // Find and return a product by id
    }
}