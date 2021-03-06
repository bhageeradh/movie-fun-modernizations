package org.superbiz.moviefun.moviesapi;

import java.io.Serializable;
import java.util.Objects;

public class MovieInfo implements Serializable{

    private Long id;
    private String director;
    private String title;
    private int year;
    private String genre;
    private int rating;

    public MovieInfo() {
    }

    public MovieInfo(Long id, String title, String director, String genre, int rating, int year) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.rating = rating;
        this.year = year;
    }

    public MovieInfo(String director, String title, int year) {
        this.director = director;
        this.title = title;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieInfo movieInfo = (MovieInfo) o;
        return id == movieInfo.id &&
                year == movieInfo.year &&
                rating == movieInfo.rating &&
                director.equals(movieInfo.director) &&
                title.equals(movieInfo.title) &&
                genre.equals(movieInfo.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, director, title, year, genre, rating);
    }
}
