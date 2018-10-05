package com.stackroute.movieservice.controller;

import com.stackroute.movieservice.Exception.MovieNotFoundException;
import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class MovieController {

    @Autowired
    MovieService movieService;

    ResponseEntity responseEntity;
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }


    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("movie")
    public ResponseEntity<?> addMovie(@RequestBody Movie movie){

        try {

            Movie savedMovie = movieService.addMovie(movie);

             responseEntity= new ResponseEntity<Movie>(savedMovie, HttpStatus.OK);

        }
        catch (Exception exception){
            responseEntity=new ResponseEntity<String>("Unsuccessful creation",HttpStatus.CONFLICT);
        }

        return responseEntity;

    }

    @GetMapping("view")
    public ResponseEntity<?> viewAllMovies(){
        List<Movie> movieList;
        movieList=  movieService.viewSavedMovie();
        ResponseEntity responseEntity = new ResponseEntity<List<Movie>>(movieList,HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> deleteMovie(@RequestBody Movie movie){
        ResponseEntity responseEntity;
        try {

            movieService.deleteMovie(movie);
            responseEntity = new ResponseEntity(movie, HttpStatus.OK);
            return responseEntity;
        }
        catch (MovieNotFoundException mo){
            responseEntity=new ResponseEntity<String>("Unsuccessful creation",HttpStatus.CONFLICT);
            return responseEntity;
        }
    }


    @PutMapping("update")
    public ResponseEntity<?> updateMovie(@RequestBody Movie movie){

        ResponseEntity responseEntity;
        try {
            movieService.updateMovie(movie);
            responseEntity = new ResponseEntity(movie, HttpStatus.OK);
            return responseEntity;
        }
        catch (MovieNotFoundException mo){
            responseEntity=new ResponseEntity<String>("Unsuccessful creation",HttpStatus.CONFLICT);
            return responseEntity;
        }
    }



    @GetMapping("search/{title}")
    public ResponseEntity<?>  searchByTitle(@PathVariable("title") String title) {
        ResponseEntity responseEntity;
        try {
            Movie searchedMovie = movieService.findMovieByName(title);
            responseEntity = new ResponseEntity<Movie>(searchedMovie, HttpStatus.OK);
            return responseEntity;
        }
        catch(MovieNotFoundException mo){
            responseEntity=new ResponseEntity<String>(mo.getMessage(),HttpStatus.CONFLICT);
            return  responseEntity;
        }
    }

}
