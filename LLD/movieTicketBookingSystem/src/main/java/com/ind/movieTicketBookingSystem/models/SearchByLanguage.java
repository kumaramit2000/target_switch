package com.ind.movieTicketBookingSystem.models;

import com.ind.movieTicketBookingSystem.interfaces.MovieSearchStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class SearchByLanguage implements MovieSearchStrategy {

    @Override
    public List<Movie> search(List<Movie> movies, String lang) {
        return  movies.stream()
                .filter(movie -> movie.getLanguage().equalsIgnoreCase(lang))
                .collect(Collectors.toList());
    }
}
