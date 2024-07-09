package com.cinemaZone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.beans.factory.annotation.Autowired;

import com.cinemaZone.entities.User;
//import com.cinemaZone.repository.UserRepository;

public interface UserService 
{
	@Autowired
	public User addUser(User u);
	public boolean emailExist(String email);
	public boolean checkPassword(String email,String password);
	public List<User> getUsersList();
//	public boolean isPremium(String email);
	public User getUser(String email);
	public void setPremiumTrue(String email);
}
