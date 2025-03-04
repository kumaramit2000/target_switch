package com.example.parkingLot.entities;

import com.example.parkingLot.enums.SpotStatus;
import com.example.parkingLot.enums.SpotType;

public class ParkingSpot {
    String spotId;
    SpotStatus spotStatus;
    String parkingSpotFloor;
    SpotType parkingSpotType;

    public ParkingSpot(String spotId, String parkingSpotFloor, SpotType parkingSpotType) {
        this.spotId = spotId;
        this.spotStatus = SpotStatus.FREE;
        this.parkingSpotFloor = parkingSpotFloor;
        this.parkingSpotType = parkingSpotType;
    }

    public String getSpotId() {
        return spotId;
    }

    public SpotStatus getSpotStatus() {
        return spotStatus;
    }

    public String getParkingSpotFloor() {
        return parkingSpotFloor;
    }

    public SpotType getParkingSpotType() {
        return parkingSpotType;
    }
}
