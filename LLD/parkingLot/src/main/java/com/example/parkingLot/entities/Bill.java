package com.example.parkingLot.entities;

import com.example.parkingLot.enums.BillStatus;
import com.example.parkingLot.interfaces.PaymentStrategy;

import java.util.Date;

public class Bill {
    String billingId;
    Ticket ticket;
    Date exitTime;
    PaymentStrategy paymentStrategy;
    Gate gate;
    BillStatus billStatus;
}
