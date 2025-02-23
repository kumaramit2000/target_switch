package com.example.LibraryManagementSystem.models;

public abstract class User {
    private String id;
    private String name;
    private String mobile;
    private String gender;
    private String email;
    /*
    User :

    Common behavior for Member and Librarian like :
        -> Can search for books...
        -> Interacts with the library system...
    */

    public User(String id, String name, String mobile, String gender, String email) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.gender = gender;
        this.email = email;
    }

//    Another Aproach : If Members and Librarians share the same logic but have different permissions...
//    public abstract void checkoutBook(String bookId);
//    public abstract void returnBook(String bookId);
//    public abstract void renewBook(String bookId);
//    public abstract void reserveBook(String bookId);


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }
}
