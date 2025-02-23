package com.example.LibraryManagementSystem.models;

import com.example.LibraryManagementSystem.enums.AccountStatus;

public class LibraryCard {
    private String cardNumber;
    private AccountStatus status;

    public LibraryCard(String cardNumber, AccountStatus status) {
        this.cardNumber = cardNumber;
        this.status = status;
    }

    public String getCardNumber() { return cardNumber; }
    public AccountStatus getStatus() { return status; }

    public boolean isActive() {
        return status == AccountStatus.ACTIVE;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }
}
