package com.example.airlineManagementSystem.models;

public class Itinerary {
    private String customerId;
    private Airport startingAirport;
    private Airport finalAirport;
    private Date creationDate;
    private List<FlightReservation> reservations;

    public Itinerary() {
        reservations = new ArrayList<>();
    }

    public boolean makeReservation(FlightReservation reservation) {
        reservations.add(reservation);
        System.out.println("Reservation added to itinerary.");
        return true;
    }

    public boolean makePayment(Payment payment) {
        payment.processPayment();
        return true;
    }

    public List<FlightReservation> getReservations() {
        return reservations;
    }
}
