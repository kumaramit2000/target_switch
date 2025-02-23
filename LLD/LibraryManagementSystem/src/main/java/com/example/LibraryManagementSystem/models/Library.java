package com.example.LibraryManagementSystem.models;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Library {
    private List<BookItem> bookItems;
    private List<Shelf> shelves;

    public Library(List<BookItem> bookItems, List<Shelf> shelves) {
        this.bookItems = bookItems;
        this.shelves = shelves;
    }

    public List<Book> searchByTitle(String title) {
        return bookItems.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    public List<Book> searchByAuthor(String author) {
        return bookItems.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public List<Book> searchBySubject(String subject) {
        return bookItems.stream()
                .filter(book -> book.getSubject().equalsIgnoreCase(subject))
                .collect(Collectors.toList());
    }

    public List<Book> searchByPublishedDate(int year) {
        return bookItems.stream()
                .filter(book -> book.getPublishedYear() == year)
                .collect(Collectors.toList());
    }

    public BookItem searchByBarcode(String barcode) {
        return bookItems.stream()
                .filter(item -> item.getBarcode().equals(barcode))
                .findFirst()
                .orElse(null);
    }

    public void addShelf(Shelf shelf) {
        shelves.add(shelf);
    }

    public Optional<Shelf> findShelfById(String shelfId) {
        return shelves.stream().filter(shelf -> shelf.getShelfId().equals(shelfId)).findFirst();
    }

    public void displayLibraryLayout() {
        System.out.println("Library Layout:");
        for (Shelf shelf : shelves) {
            System.out.println("Shelf ID: " + shelf.getShelfId() + " | Category: " + shelf.getCategory());
            for (BookItem bookItem : shelf.getBookItems()) {
                System.out.println(" - " + bookItem.getTitle() + " (Barcode: " + bookItem.getBarcode() + ")");
            }
        }
    }
}
