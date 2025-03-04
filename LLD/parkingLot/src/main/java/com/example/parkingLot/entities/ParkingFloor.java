package com.example.parkingLot.entities;

import com.example.parkingLot.enums.VehicleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingFloor {
    String floorId;
    List<ParkingSpot> filledSpots;
    List<ParkingSpot> availableSpots;

    public ParkingFloor(String floorId, List<ParkingSpot> availableSpots) {
        this.floorId = floorId;
        this.filledSpots = new ArrayList<>();
        this.availableSpots = availableSpots;
    }

    public ParkingSpot findAvailableSpot(VehicleType type) {
        return availableSpots.stream().filter(s -> s.getParkingSpotType().toString().equals(type.toString())).findFirst().orElse(null);
    }


}
