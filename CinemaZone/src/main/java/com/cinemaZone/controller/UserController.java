package com.cinemaZone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cinemaZone.entities.Movie;
import com.cinemaZone.entities.User;
import com.cinemaZone.service.MovieService;
import com.cinemaZone.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController 
{
	@Autowired
	private UserService uSer;
	@PostMapping("/createUser")
	public String createUser(@ModelAttribute ("User")User u)
	{
		boolean status=uSer.emailExist(u.getEmail());
		if(status == true) {
			System.out.println("Registration failed");
			return "reg_failed";
		}
		else {
			uSer.addUser(u);
			System.out.println("Registered successfully");
			return "res_success";
		}
	}
	@PostMapping("/loginUser")
	public String loginUser(@RequestParam String email,@RequestParam String password, HttpSession session)
	{
		session.setAttribute("email", email);
		boolean status=uSer.emailExist(email);
		if(email.equals("admin@gmail.com") && password.equals("admin123"))
		{
			return "admin_home";
		}
		if(status==true)
		{
			if(uSer.checkPassword(email,password))
			{
				
				return "userHome";
			}
			else {
				System.out.println("Password Incorrect");
				return "login_failed";
			}
			
		}
		else {
			return "login_failed";
		}
		
	}
	@GetMapping("pay")
	public String pay(HttpSession session)
	{
		String email=(String)session.getAttribute("email");
		uSer.setPremiumTrue(email);
		return "lohin_form";
	}
	
	@GetMapping("view_users")
	public String viewUsers(Model model)
	{
		List<User> usersList=uSer.getUsersList();
		model.addAttribute("user",usersList);
		return "user_details";
	}
	@PostMapping("/updateUser")
	public String updateUser(User user)
	{
		boolean status=uSer.emailExist(user.getEmail());
		if(status == false) {
			System.out.println("Updation failed");
			return "<h1>Updation failed Email does not exist</h1>";
		}
		else {
			uSer.addUser(user);
			System.out.println("Registered successfully");
			return "update_success";
		}
	}
	
	@GetMapping("explore_movies")
	public String explore_movies(HttpSession session)
	{
		String email=(String)session.getAttribute("email");
		User usr=uSer.getUser(email);
		if(usr.isPremium())
		{
			return "user_movies";
		}
		else {
			return "payment";
		}
	}
	MovieService movieSer;
	@GetMapping("user_movies")
	public String user_movies(Model model)
	{
		List<Movie> moviesList=movieSer.getAllMovies();
		model.addAttribute("movie",moviesList);
		return "user_movies";
	}
}
