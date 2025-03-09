package com.ind.movieTicketBookingSystem.models;

import com.ind.movieTicketBookingSystem.enums.PaymentStatus;

public class Payment {
    private String paymentId;
    private double amount;
    private PaymentStatus status;

    public Payment(String paymentId, double amount) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.status = PaymentStatus.PENDING;
    }

    public void processPayment() {
        this.status = PaymentStatus.COMPLETED;
        System.out.println("Payment of $" + amount + " was successful.");
    }
}
