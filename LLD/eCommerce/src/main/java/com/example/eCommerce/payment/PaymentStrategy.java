package com.example.eCommerce.payment;

public interface PaymentStrategy {
    boolean pay(double amount);
}
