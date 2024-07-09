package com.cinemaZone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemaZone.entities.Movie;
import com.cinemaZone.repository.MovieRepository;

@Service
public class MovieServiceImplementation implements MovieService
{
	@Autowired
	MovieRepository movieRepo;
	@Override
	public Movie addMovie(Movie movie) {
		return movieRepo.save(movie);
	}
	@Override
	public List<Movie> getAllMovies() {
		return movieRepo.findAll();
	}
	
	
}
