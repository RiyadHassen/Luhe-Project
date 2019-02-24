package com.Luhe.Luhe.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.Luhe.Luhe.domains.Catagory;
import com.Luhe.Luhe.services.CatagoryService;

@Controller
public class HomeController {
	
	@Autowired
	private CatagoryService catagoryService;
	
	public HomeController(CatagoryService catagoryService)
	{
		this.catagoryService=catagoryService;
	}
	
	@ModelAttribute("catagories")
	public List<Catagory> listCatagory(Model model) {
		return (List<Catagory>) catagoryService.findAll();
	}
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("/about")
	public String about()
	{
		return "about";
	}
	
	
}


