package com.Luhe.Luhe.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Luhe.Luhe.domains.Article;
import com.Luhe.Luhe.Repository.ArticleRepository;


@Service
public class ArticleServicesImp implements ArticleService{
	ArticleRepository articleRepository;
	
	@Autowired
	public ArticleServicesImp (ArticleRepository articleRepository)
	{
		this.articleRepository=articleRepository;
	}
	
	@Override
	public Article save(Article article) {
		return articleRepository.save(article);
	}

	@Override
	public Iterable<Article> saveAll(Iterable<Article> articles) {
		return articleRepository.saveAll(articles);
	}

	@Override
	public Optional<Article> findById(Long id) {
		return  articleRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return  articleRepository.existsById(id);
	}

	@Override
	public List<Article> findAll() {
		 List<Article> all = (List<Article>) articleRepository.findAll();
		return all;
	}

	@Override
	public Iterable<Article> findAllById(Iterable<Long> ids) {
		return articleRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return  articleRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		 articleRepository.deleteById(id);         
	}

	@Override
	public void delete(Article article) {
		 articleRepository.delete(article);
		
	}

	@Override
	public void deleteAll(Iterable<Article> articles) {
		 articleRepository.deleteAll(articles);
	}
	public Article getById(Long id) {
		return  articleRepository.findById(id).get();
	}
	public Article update(Article article) {
		return articleRepository.save(article);
	}

	@Override
	public void deleteAll() {
		 articleRepository.deleteAll();
	}
	public List<Article> getAll() {
		 List<Article> all = (List<Article>) articleRepository.findAll();
		 Collections.reverse(all);
		return all;
	}

	
	

	@Override
	public List<Article> findByCatagoryType(String c) {
		return articleRepository.findByCatagoryType(c);
	}


	
}
