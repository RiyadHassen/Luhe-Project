package com.Luhe.Luhe.services;


import java.util.List;
import java.util.Optional;

import com.Luhe.Luhe.domains.Article;


public interface ArticleService {
	public Article save(Article Article);
	public  Iterable<Article> saveAll(Iterable<Article> Articles);
	
	Optional<Article> findById(Long id);
	boolean existsById(Long id);
	Iterable<Article> findAll();
	Iterable<Article> findAllById(Iterable<Long> ids);

	long count();
	void deleteById(Long id);
	void delete(Article Article);
	void deleteAll();
	void deleteAll(Iterable<Article> Articles);
	
	
    List<Article> findByCatagoryType(String c);
    public Article getById(Long id);
}
