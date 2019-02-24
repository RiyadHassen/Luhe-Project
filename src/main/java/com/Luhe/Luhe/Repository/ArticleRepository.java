package com.Luhe.Luhe.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Luhe.Luhe.domains.Article;
import com.Luhe.Luhe.domains.Catagory;
 
public interface ArticleRepository extends CrudRepository<Article, Long> {
	List<Article> findByCatagory(Catagory c);
	List<Article> findByCatagoryType(String c);
}
