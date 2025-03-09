package com.ind.movieTicketBookingSystem.models;

import java.time.LocalDate;
import java.util.List;

public class Movie {
    String title;
    String description;
    Integer durationInMins;
    String language;
    LocalDate releaseDate;
    String country;
    String genre;
    Admin addedBy;
    List<Show> show;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Integer getDurationInMins() {
        return durationInMins;
    }

    public String getLanguage() {
        return language;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public String getCountry() {
        return country;
    }

    public String getGenre() {
        return genre;
    }

    public Admin getAddedBy() {
        return addedBy;
    }

    public List<Show> getShow() {
        return show;
    }
}
