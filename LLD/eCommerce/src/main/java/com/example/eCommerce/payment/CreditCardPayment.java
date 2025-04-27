package com.example.eCommerce.payment;

public class CreditCardPayment implements PaymentStrategy{
    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;
    private String cvv;

    public CreditCardPayment(String cardNumber, String cardHolderName, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card.");
        return true;
    }
}
