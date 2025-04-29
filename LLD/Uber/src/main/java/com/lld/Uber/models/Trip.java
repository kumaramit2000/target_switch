package com.lld.Uber.models;

import com.lld.Uber.enums.TripStatus;
import com.lld.Uber.interfaces.DriverMatchingStrategy;
import com.lld.Uber.interfaces.PricingStrategy;

public class Trip {
    private int tripId;
    private Rider rider;
    private Driver driver;
    private Location src;
    private Location dest;
    private TripStatus tripStatus;
    private double price;
    private PricingStrategy pricingStrategy;
    private DriverMatchingStrategy driverMatchingStrategy;

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Location getSrc() {
        return src;
    }

    public void setSrc(Location src) {
        this.src = src;
    }

    public Location getDest() {
        return dest;
    }

    public void setDest(Location dest) {
        this.dest = dest;
    }

    public TripStatus getTripStatus() {
        return tripStatus;
    }

    public void setTripStatus(TripStatus tripStatus) {
        this.tripStatus = tripStatus;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
