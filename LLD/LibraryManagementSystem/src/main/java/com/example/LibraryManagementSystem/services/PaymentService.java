package com.example.LibraryManagementSystem.services;

import com.example.LibraryManagementSystem.interfaces.Transaction;
import com.example.LibraryManagementSystem.models.Fine;
import com.example.LibraryManagementSystem.models.Member;

import java.util.List;

public class PaymentService {

    public static void processFinePayment(Member member, Transaction transaction) {
        List<Fine> unpaidFines = member.getUnpaidFines();
        if (unpaidFines.isEmpty()) {
            System.out.println("No unpaid fines.");
            return;
        }

        double totalAmount = unpaidFines.stream().mapToDouble(Fine::getAmount).sum();
        transaction.processPayment(totalAmount);
        unpaidFines.forEach(Fine::payFine);
    }
}
