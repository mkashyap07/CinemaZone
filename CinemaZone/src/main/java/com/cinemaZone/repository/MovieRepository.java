package com.cinemaZone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinemaZone.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie,Integer>
{

}
