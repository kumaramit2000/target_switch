package com.ind.movieTicketBookingSystem.interfaces;

import com.ind.movieTicketBookingSystem.models.Movie;

import java.time.LocalDate;
import java.util.List;

public interface MovieSearchStrategy {

    List<Movie> search(List<Movie> movies, String searchParam);

}
