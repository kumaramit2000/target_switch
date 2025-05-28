package com.example.airlineManagementSystem.models;

public class Seat {
    private String seatNumber;
    private SeatType type;
    private SeatClass seatClass;

    public Seat(String seatNumber, SeatType type, SeatClass seatClass) {
        this.seatNumber = seatNumber;
        this.type = type;
        this.seatClass = seatClass;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public SeatType getType() {
        return type;
    }

    public SeatClass getSeatClass() {
        return seatClass;
    }
}
