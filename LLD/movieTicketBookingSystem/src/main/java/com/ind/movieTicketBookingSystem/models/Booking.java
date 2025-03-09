package com.ind.movieTicketBookingSystem.models;

import com.ind.movieTicketBookingSystem.enums.BookingStatus;

import java.util.List;

public class Booking {
    String bookingId;
    List<CinemaHallSeat> seats;
    BookingStatus bookingStatus;
    Show show;
    Movie movie;
    ShowSeats showSeats;
    Payment payment;

    public boolean cancelBooking(){
        return true;
    }

    public void confirmBooking() {
        this.bookingStatus = BookingStatus.CONFIRMED;
        System.out.println("Booking confirmed for " + movie.getTitle());
    }

}
