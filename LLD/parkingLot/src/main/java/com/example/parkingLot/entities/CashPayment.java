package com.example.parkingLot.entities;

import com.example.parkingLot.interfaces.PaymentStrategy;

public class CashPayment implements PaymentStrategy {

    @Override
    public boolean pay(double amount) {
        System.out.println("Paid " + amount + " using Cash.");
        return true;
    }
}
