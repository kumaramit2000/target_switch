package com.example.airlineManagementSystem.models;

public class Aircraft {
    private String name;
    private String model;
    private int manufacturingYear;
    private List<Seat> seats;

    public Aircraft(String name, String model, int manufacturingYear) {
        this.name = name;
        this.model = model;
        this.manufacturingYear = manufacturingYear;
        this.seats = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public int getManufacturingYear() {
        return manufacturingYear;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void addSeat(Seat seat) {
        seats.add(seat);
        System.out.println("Seat " + seat.getSeatNumber() + " added to aircraft: " + name);
    }
}
