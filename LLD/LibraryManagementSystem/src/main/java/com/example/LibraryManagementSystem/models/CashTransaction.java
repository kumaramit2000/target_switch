package com.example.LibraryManagementSystem.models;

import com.example.LibraryManagementSystem.interfaces.Transaction;

public class CashTransaction implements Transaction {

    @Override
    public void processPayment(double amount) {
        System.out.println("Paid $" + amount + " using Cash. No receipt generated.");
    }
}
