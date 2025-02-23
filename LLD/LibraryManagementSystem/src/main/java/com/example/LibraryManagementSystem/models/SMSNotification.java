package com.example.LibraryManagementSystem.models;

import com.example.LibraryManagementSystem.interfaces.Notification;

public class SMSNotification implements Notification {

    @Override
    public void sendNotification(String message, User user) {
        System.out.println("Sending SMS to " + user.getMobile() + ": " + message);
    }
}
