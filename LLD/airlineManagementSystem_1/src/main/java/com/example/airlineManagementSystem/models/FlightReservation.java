package com.example.airlineManagementSystem.models;

public class FlightReservation {
    private String reservationNumber;
    private FlightInstance flight;
    private Map<Passenger, FlightSeat> seatMap;
    private Date creationDate;
    private ReservationStatus status;

    public FlightReservation(FlightInstance flight, Map<Passenger, FlightSeat> seatMap) {
        this.flight = flight;
        this.seatMap = seatMap;
        this.status = ReservationStatus.REQUESTED;
    }

    public boolean cancel() {
        this.status = ReservationStatus.CANCELLED;
        System.out.println("Reservation has been canceled.");
        return true;
    }

    public boolean confirm() {
        this.status = ReservationStatus.CONFIRMED;
        System.out.println("Reservation confirmed.");
        return true;
    }
}
