package com.example.parkingLot.entities;

import com.example.parkingLot.enums.VehicleType;

public class Vehicle {
    String vehicleNo;
    VehicleType vehicleType;

    public Vehicle(String vehicleNo, VehicleType vehicleType) {
        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
