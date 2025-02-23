package com.example.LibraryManagementSystem.interfaces;

import com.example.LibraryManagementSystem.models.User;

public interface Notification {
    void sendNotification(String message, User user);
}
