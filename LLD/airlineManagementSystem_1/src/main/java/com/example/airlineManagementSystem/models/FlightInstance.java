package com.example.airlineManagementSystem.models;

public class FlightInstance {
    private Date departureTime;
    private String gate;
    private FlightStatus status;
    private Aircraft aircraft;

    public FlightInstance(Date departureTime, String gate, Aircraft aircraft) {
        this.departureTime = departureTime;
        this.gate = gate;
        this.aircraft = aircraft;
        this.status = FlightStatus.SCHEDULED;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public String getGate() {
        return gate;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public void updateStatus(FlightStatus status) {
        this.status = status;
        System.out.println("Flight status updated to: " + status);
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public boolean cancel() {
        this.status = FlightStatus.CANCELLED;
        System.out.println("Flight instance canceled.");
        return true;
    }
}
