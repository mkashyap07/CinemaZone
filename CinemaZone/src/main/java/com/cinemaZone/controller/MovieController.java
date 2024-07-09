package com.cinemaZone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cinemaZone.entities.Movie;
import com.cinemaZone.service.MovieService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MovieController 
{
//	HttpSession session;
	@Autowired
	MovieService movieSer;
	@PostMapping("addmovie")
	public String addMovie(@ModelAttribute ("Movie")Movie movie)
	{
		movieSer.addMovie(movie);
		return "movieaddsuccess";
	}
	@GetMapping("movies_details")
	public String moviesDetails(Model model)
	{
		List<Movie> moviesList=movieSer.getAllMovies();
		model.addAttribute("movie",moviesList);
		return "movie_details";
	}
//	@GetMapping("user_movies")
//	public String user_movies(Model model)
//	{
//		List<Movie> moviesList=movieSer.getAllMovies();
//		model.addAttribute("movie",moviesList);
//		return "user_movies";
//	}

}
