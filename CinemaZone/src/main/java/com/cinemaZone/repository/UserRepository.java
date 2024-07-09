package com.cinemaZone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinemaZone.entities.User;

public interface UserRepository extends JpaRepository<User,Integer>
{
	public User findByEmail(String email);
}
