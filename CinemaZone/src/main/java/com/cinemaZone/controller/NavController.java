package com.cinemaZone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController 
{
	@GetMapping("/")
	public String index()
	{
		return "index";
	}
	@GetMapping("map_register")
	public String map_register()
	{
		return "register_form";
	}
	@GetMapping("map_login")
	public String map_login()
	{
		return "login_form";
	}
	@GetMapping("add_movie")
	public String addMoviePage()
	{
		return "addmovieform";
	}
	@GetMapping("map_update")
	public String map_update()
	{
		return "update_form";
	}
}
