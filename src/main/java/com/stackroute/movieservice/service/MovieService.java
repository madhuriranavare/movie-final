package com.stackroute.movieservice.service;


import com.stackroute.movieservice.Exception.MovieNotFoundException;
import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {

    public Movie addMovie(Movie movie) throws MovieNotFoundException;
    public List<Movie> viewSavedMovie();
    public void deleteMovie(Movie movie) throws MovieNotFoundException;
    public void updateMovie(Movie movie) throws MovieNotFoundException;
    public Movie findMovieByName(String name) throws MovieNotFoundException;
}
