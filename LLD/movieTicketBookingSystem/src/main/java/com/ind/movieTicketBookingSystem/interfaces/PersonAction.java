package com.ind.movieTicketBookingSystem.interfaces;

public interface PersonAction {
    void searchMovie(String ticketId);
    void createBooking();
    void makePayment();
    void viewBooking();
    void cancelBooking();
}
