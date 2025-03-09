package com.ind.movieTicketBookingSystem.models;

import java.time.LocalDate;

public class Show {
    String id;
    LocalDate createdOn;
    LocalDate startTime;
    LocalDate endTime;
    CinemaHall playedAt;
    Movie movie;
}
