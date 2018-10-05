package com.stackroute.movieservice.service;


import com.stackroute.movieservice.Exception.MovieNotFoundException;
import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public Movie addMovie(Movie movie) throws MovieNotFoundException {
        ResponseEntity responseEntity;
        Movie savedMovie = movieRepository.save(movie);
        return savedMovie;

    }

    @Override
    public List<Movie> viewSavedMovie() {
        List<Movie> viewMovie = (List<Movie>) movieRepository.findAll();
        return viewMovie;
    }

    @Override
    public void deleteMovie(Movie movie) throws MovieNotFoundException {
        if (movieRepository.existsById(movie.getID())) {

            movieRepository.delete(movie);
        } else {
            throw new MovieNotFoundException();
        }
    }


    @Override
    public void updateMovie(Movie movie) throws MovieNotFoundException {
        if (movieRepository.existsById(movie.getID())) {
            Movie movie1 = movieRepository.getOne(movie.getID());
            movie1.setComment(movie.getComment());
            movieRepository.save(movie1);

        } else {
            throw new MovieNotFoundException();
        }
    }

//    @Override
//    public List<Movie> findMovieByName(String name) {
//        List<Movie> moviess = new ArrayList<>();
//        for(Movie m: viewSavedMovie()) {
//            if(m.getMovieTitle().compareTo(name)==0) {
//                moviess.add(m);
//            }
//        }
//        return moviess;
//    }

    @Override
    public Movie findMovieByName(String name) throws MovieNotFoundException {
        if (movieRepository.findBymovieTitle(name) != null) {


            Movie search = movieRepository.findBymovieTitle(name);

            return search;

        } else {

            throw new MovieNotFoundException();

        }
    }
}
