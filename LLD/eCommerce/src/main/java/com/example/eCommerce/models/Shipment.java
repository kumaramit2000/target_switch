package com.example.eCommerce.models;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public class Shipment {
    private String shipmentNumber;
    private LocalDateTime shipmentDate;
    private LocalDateTime estimatedArrival;
    private String shipmentMethod;

}
