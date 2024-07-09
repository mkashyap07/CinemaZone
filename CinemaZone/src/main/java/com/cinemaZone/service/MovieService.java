package com.cinemaZone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemaZone.entities.Movie;
@Service
public interface MovieService 
{
	@Autowired
	public Movie addMovie(Movie movie);

	public List<Movie> getAllMovies();
	
	

}
