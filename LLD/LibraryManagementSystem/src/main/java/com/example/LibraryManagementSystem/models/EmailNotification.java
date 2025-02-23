package com.example.LibraryManagementSystem.models;

import com.example.LibraryManagementSystem.interfaces.Notification;

public class EmailNotification implements Notification {

    @Override
    public void sendNotification(String message, User user) {
        System.out.println("Sending Email to " + user.getEmail() + ": " + message);
    }
}
