package com.example.airlineManagementSystem.models;

public class Airport {
    private String name;
    private Address address;
    private String code;
    private List<Flight> flights;

    public Airport(String name, Address address, String code) {
        this.name = name;
        this.address = address;
        this.code = code;
        flights = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public String getCode() {
        return code;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
        System.out.println("Flight added to airport: " + flight.getFlightNumber());
    }
}
