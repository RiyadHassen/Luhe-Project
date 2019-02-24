package com.Luhe.Luhe.controllers;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.Luhe.Luhe.domains.Article;
import com.Luhe.Luhe.domains.Catagory;
import com.Luhe.Luhe.services.ArticleService;
import com.Luhe.Luhe.services.CatagoryServicesImp; 
@Controller
@RequestMapping("/Article")
public class ArticleController {
	
	private ArticleService articleService;
	private CatagoryServicesImp catagoryService;
	@Autowired
	public ArticleController(ArticleService articleService, CatagoryServicesImp catagoryService)
	{
		this.articleService=articleService;
		this.catagoryService = catagoryService;
	}
	@ModelAttribute("article")
	public Article createArticle(Model model) {
		return new Article();
	}
	@ModelAttribute("articles")
	public List<Article> createArticles(Model model) {
		return (List<Article>) articleService.findAll();
	}
	@ModelAttribute("catagories")
	public List<Catagory> listCatagory(Model model) {
		return (List<Catagory>) catagoryService.findAll();
	}
	
	
	@GetMapping
	public String showArticleForm(Model model) {
		return "ArticleForm";
	}
	@GetMapping("/current")
	public String DisplayArticle()
	{
		return "Article";
	}
	
	@GetMapping("/current2")
	public String DisplayArticles()
	{
		return "Article2";
	}
	@GetMapping("/each")
	public String EachView() {
		return "EachViewArticle";
	}
	
	@GetMapping("/each/{id}")
	public String eachArticleView(@PathVariable("id") Long id, Model model) {
		
		Article eachArticle =articleService.getById(id);
		//Article.setId(id);
		model.addAttribute("article",eachArticle);
		return "EachViewArticle";
		
	}
	@PostMapping
	public String saveArticle(@Valid  Article article,Errors errors)
	{
		if (errors.hasErrors()) {
			return "ArticleForm";
		}
		articleService.save(article);
		return "redirect:/Article/current";
	}
	@GetMapping("/{id}")
	public String getOne(@PathVariable("id") long id,Model model)
	{
		model.addAttribute("articleOne", articleService.getById(id));
		
		return "store";
	}
    @PostMapping("/like/{id}")
    public String likeRating(@PathVariable("id")long id)
    {
    	Article a = articleService.getById(id);
    	a.setLikeRate(a.getLikeRate() + 1);
    	articleService.save(a);
    	return "redirect:/Article/each/"+id ;
    }
    @PostMapping("/dlike/{id}")
    public String dislikeRating(@PathVariable("id")long id)
    {
    	Article a = articleService.getById(id);
    	a.setDislikeRate(a.getDislikeRate() + 1);
    	articleService.save(a);
    	return "redirect:/Article/each/"+id ;
    }
    @PostMapping("/deleteArticle/{id}")
	public String deleteArticle(@PathVariable("id") Long id) {
		Article article = articleService.getById(id);
		articleService.delete(article);
		return "redirect:/Article/current";
		
	}
	

	
	@GetMapping("/editForm/{id}")
	public String ShowEditForm(@PathVariable("id") Long id, Model model) {
		//Article Article = new Article();
		Article ArticleEdit =articleService.getById(id);
		//Article.setId(id);
		model.addAttribute("Article",ArticleEdit);
		return "ArticleFormEdit";
		
	}
	@PostMapping("/update/{id}")
	public String processUpdate(@PathVariable("id") Long id, @Valid Article ArticleEdit, Errors errors) {
		if (errors.hasErrors()) {
			ArticleEdit.setId(id);
			return "Article/ArticleFormEdit";
		}
		ArticleEdit.setApproval("true");
		articleService.save(ArticleEdit);
		return "redirect:/Article/current";
		
	}
}
