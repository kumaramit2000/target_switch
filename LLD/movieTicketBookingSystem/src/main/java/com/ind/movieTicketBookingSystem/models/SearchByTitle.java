package com.ind.movieTicketBookingSystem.models;

import com.ind.movieTicketBookingSystem.interfaces.MovieSearchStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class SearchByTitle implements MovieSearchStrategy {

    @Override
    public List<Movie> search(List<Movie> movies, String title) {
        return movies.stream()
                .filter(movie -> movie.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }
}
