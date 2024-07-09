package com.cinemaZone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemaZone.entities.User;
import com.cinemaZone.repository.UserRepository;

@Service
public class UserServiceImplement implements UserService{

	@Autowired
	UserRepository urepo;
	@Override
	public User addUser(User u) {
		return urepo.save(u);	
	}
	@Override
	public boolean emailExist(String email) {
		if(urepo.findByEmail(email)==null) {
		return false;
		}
		else {
			return true;
		}
	}
	@Override
	public boolean checkPassword(String email,String password) {
		String db_password=urepo.findByEmail(email).getPassword();
		if(db_password.equals(password))
		{
			return true;
		}
		else {
		return false;
		}
	}
	@Override
	public List<User> getUsersList() {
		return urepo.findAll();
	}
	
	@Override
	public User getUser(String email)
	{
		return urepo.findByEmail(email);
	}
//	@Override
//	public boolean isPremium(String email) {
//		User user=urepo.findByEmail(email);
//		if(user.isPremium == true)
//		{
//			return true;
//		}
//		else {
//			return false;
//		}
//	}
	@Override
	public void setPremiumTrue(String email) {
		User usr=urepo.findByEmail(email);
		if(usr.isPremium()==false) {
		usr.setPremium(true);
		}
	}
	

}
