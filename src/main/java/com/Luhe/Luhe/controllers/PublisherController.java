package com.Luhe.Luhe.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.Luhe.Luhe.domains.Article;
import com.Luhe.Luhe.services.ArticleService;


@Controller
@RequestMapping("/publisher")
public class PublisherController {


	@Autowired
	private ArticleService  articleService;
	@Autowired
	public PublisherController(ArticleService articleService)
	{
		this.articleService=articleService;
	}

	@ModelAttribute("articles")
	public List<Article> createArticles(Model model) {
		return (List<Article>) articleService.findAll();
	}
	

	@ModelAttribute("articles")
	public Article findEachArticles(Long id,Model model) {
		return (Article)articleService.getById(id);
	}
	@GetMapping()
	public String Displaypublisher() {
		return "Publisher";
	}
	
	@PostMapping("/deleteArticle/{id}")
	public String deleteArticle(@PathVariable("id") Long id) {
		Article articlea=articleService.getById(id);
		articleService.delete(articlea);
		return "redirect:/publisher";
		
	}
	
	@PostMapping("/approveArticle/{id}")
	public String approveArticle(@PathVariable("id") Long id) {
		Article approveById=articleService.getById(id);
		approveById.setApproval("true");
		articleService.save(approveById);
		return "redirect:/publisher";
		
	}
	
	@GetMapping("/eachView/{id}")
	public String ShowEachArticle(@PathVariable("id") Long id, Model model) {
		
		Article ArticleView =articleService.getById(id);
		model.addAttribute("article",ArticleView);
		return "EachView";
	}
}
