package com.ind.movieTicketBookingSystem.models;

public abstract class Person {
    protected String id;
    protected String name;
    protected String address;
    protected String phoneNo;

    public Person(String id, String name, String address, String phoneNo) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
    }

    public void displayDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Phone No: " + phoneNo);
    }
}
