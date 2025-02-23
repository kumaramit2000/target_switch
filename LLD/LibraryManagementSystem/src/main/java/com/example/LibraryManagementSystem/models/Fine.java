package com.example.LibraryManagementSystem.models;

import java.time.LocalDate;

public class Fine {
    private double amount;
    private boolean isPaid;
    private LocalDate dueDate;
    private LocalDate paymentDate;

    public Fine(double amount, LocalDate dueDate) {
        this.amount = amount;
        this.dueDate = dueDate;
        this.isPaid = false;
    }

    public double getAmount() { return amount; }
    public boolean isPaid() { return isPaid; }
    public LocalDate getDueDate() { return dueDate; }
    public LocalDate getPaymentDate() { return paymentDate; }

    public void payFine() {
        if (isPaid) {
            System.out.println("Fine is already paid.");
            return;
        }
        this.isPaid = true;
        this.paymentDate = LocalDate.now();
        System.out.println("Fine of $" + amount + " paid successfully.");
    }
}
