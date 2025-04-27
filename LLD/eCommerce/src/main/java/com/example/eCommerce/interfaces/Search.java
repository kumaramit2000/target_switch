package com.example.eCommerce.interfaces;

import com.example.eCommerce.models.Product;

import java.util.List;

public interface Search {
    public List<Product> searchProductsByName(String name);
    public List<Product> searchProductsByCategory(String category);
}
