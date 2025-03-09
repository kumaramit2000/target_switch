package com.ind.movieTicketBookingSystem.models;

import com.ind.movieTicketBookingSystem.interfaces.PersonAction;

public class FrontDeskOfficer extends Person implements PersonAction {

    public FrontDeskOfficer(String id, String name, String address, String phoneNo) {
        super(id, name, address, phoneNo);
    }

    @Override
    public void searchMovie(String ticketId) {

    }

    @Override
    public void createBooking() {

    }

    @Override
    public void makePayment() {

    }

    @Override
    public void viewBooking() {

    }

    @Override
    public void cancelBooking() {

    }
}
