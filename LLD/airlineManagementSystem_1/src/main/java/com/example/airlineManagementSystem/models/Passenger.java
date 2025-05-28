package com.example.airlineManagementSystem.models;

public class Passenger {
    private String name;
    private String passportNumber;
    private Date dateOfBirth;

    public Passenger(String name, String passportNumber, Date dateOfBirth) {
        this.name = name;
        this.passportNumber = passportNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }
}
