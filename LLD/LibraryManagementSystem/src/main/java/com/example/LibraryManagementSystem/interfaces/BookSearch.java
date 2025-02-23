package com.example.LibraryManagementSystem.interfaces;

import com.example.LibraryManagementSystem.models.Book;

import java.util.List;

public interface BookSearch {
    List<Book> searchByTitle(String title);
    List<Book> searchByAuthor(String author);
    List<Book> searchBySubject(String subject);
    List<Book> searchByPublishedDate(int year);
}
