package com.ind.movieTicketBookingSystem.models;

import com.ind.movieTicketBookingSystem.interfaces.MovieSearchStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class SearchByGenre implements MovieSearchStrategy {

    @Override
    public List<Movie> search(List<Movie> movies, String genre) {
        return movies.stream()
                .filter(movie -> movie.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
    }
}
