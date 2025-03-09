package com.ind.movieTicketBookingSystem.models;

import java.util.List;

public class CinemaHall {
    String name;
    Integer totalSeats;
    List<CinemaHallSeat> seats;
    List<Show> shows;
}
