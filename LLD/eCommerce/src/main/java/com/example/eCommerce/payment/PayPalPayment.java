package com.example.eCommerce.payment;

public class PayPalPayment implements PaymentStrategy{
    private String emailId;

    public PayPalPayment(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Paid ₹" + amount + " using PayPal.");
        return true;
    }
}
