package com.Luhe.Luhe.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Luhe.Luhe.services.ArticleService;


@Controller
public class CatagoryController {
	private ArticleService articleService;

	@Autowired
	public CatagoryController(ArticleService articleService)
	{
		this.articleService=articleService;
	}
	@GetMapping("/{Catagory}")
	public String dispalyByCatagory(@PathVariable("Catagory")String cat,Model model)
	{
		model.addAttribute("cat", articleService.findByCatagoryType(cat));
		return "Category";
	}
	
}
