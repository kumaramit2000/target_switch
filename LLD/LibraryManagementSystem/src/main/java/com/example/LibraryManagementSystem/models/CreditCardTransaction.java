package com.example.LibraryManagementSystem.models;

import com.example.LibraryManagementSystem.interfaces.Transaction;

public class CreditCardTransaction implements Transaction {
    private String cardNumber;

    public CreditCardTransaction(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card (Card No: " + cardNumber + ").");
    }
}
