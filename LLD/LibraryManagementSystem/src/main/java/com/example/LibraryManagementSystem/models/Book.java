package com.example.LibraryManagementSystem.models;

public class Book {
    private String title;
    private String author;
    private String subject;
    private int publishedYear;

    public Book(String title, String author, String subject, int publishedYear) {
        this.title = title;
        this.author = author;
        this.subject = subject;
        this.publishedYear = publishedYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getSubject() {
        return subject;
    }

    public int getPublishedYear() {
        return publishedYear;
    }
}
