package com.stackroute.movieservice.domain;

import org.springframework.beans.factory.support.MethodOverride;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie {

    @Id private int id;
    private String movieTitle;
    private String posterURL;
    private float rating;
    private String yearOfRelease;
    private String comment;

    public Movie() {
    }

    public Movie(int id, String movieTitle, String posterURL, float rating, String yearOfRelease, String comment) {
        this.id = id;
        this.movieTitle = movieTitle;
        this.posterURL = posterURL;
        this.rating = rating;
        this.yearOfRelease = yearOfRelease;
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getPosterURL() {
        return posterURL;
    }

    public void setPosterURL(String posterURL) {
        this.posterURL = posterURL;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(String yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }






    public int getID() {
        return id;
    }

    public void setID(int movieId) {
        this.id = movieId;
    }
}
