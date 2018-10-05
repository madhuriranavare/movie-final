package com.stackroute.movieservice.Exception;

public class MovieNotFoundException extends Exception{
    @Override
    public String getMessage(){
        return "Movie is not found in database";
    }
}
