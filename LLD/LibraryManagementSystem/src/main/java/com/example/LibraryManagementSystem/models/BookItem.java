package com.example.LibraryManagementSystem.models;

import java.time.LocalDate;

public class BookItem extends Book{
    private String barcode;
    private boolean isAvailable;
    private LocalDate dueDate;
    private Shelf shelf; // New association

    public BookItem(String title, String author, String subject, int publishedYear, String barcode, Shelf shelf) {
        super(title, author, subject, publishedYear);
        this.barcode = barcode;
        this.isAvailable = true;
        this.shelf = shelf;
        this.dueDate=null;
    }

    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { this.isAvailable = available; }
    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }
    public String getBarcode() { return barcode; }

    public Shelf getShelf() { return shelf; }

    public void setShelf(Shelf shelf) {
        this.shelf = shelf;
    }
}
