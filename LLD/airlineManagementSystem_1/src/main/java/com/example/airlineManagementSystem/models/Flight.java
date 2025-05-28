package com.example.airlineManagementSystem.models;

public class Flight {

    private String flightNumber;
    private Airport departure;
    private Airport arrival;
    private int durationInMinutes;
    private List<FlightInstance> flightInstances;

    public Flight(String flightNumber, Airport departure, Airport arrival, int durationInMinutes) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.arrival = arrival;
        this.durationInMinutes = durationInMinutes;
        this.weeklySchedules = new ArrayList<>();
        this.customSchedules = new ArrayList<>();
        this.flightInstances = new ArrayList<>();
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public Airport getDeparture() {
        return departure;
    }

    public Airport getArrival() {
        return arrival;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void addWeeklySchedule(WeeklySchedule schedule) {
        weeklySchedules.add(schedule);
        System.out.println("Weekly schedule added to flight: " + flightNumber);
    }

    public void addCustomSchedule(CustomSchedule schedule) {
        customSchedules.add(schedule);
        System.out.println("Custom schedule added to flight: " + flightNumber);
    }

    public void addFlightInstance(FlightInstance flightInstance) {
        flightInstances.add(flightInstance);
        System.out.println("Flight instance added: " + flightInstance.getGate() + " for flight: " + flightNumber);
    }

    public List<FlightInstance> getFlightInstances() {
        return flightInstances;
    }
}
