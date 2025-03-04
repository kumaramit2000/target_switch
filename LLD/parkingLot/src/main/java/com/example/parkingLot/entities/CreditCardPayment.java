package com.example.parkingLot.entities;

import com.example.parkingLot.interfaces.PaymentStrategy;

public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    @Override
    public boolean pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card: " + cardNumber);
        return true;
    }
}
