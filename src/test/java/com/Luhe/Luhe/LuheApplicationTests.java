package com.Luhe.Luhe;




import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.Luhe.Luhe.services.*;
import com.Luhe.Luhe.domains.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class LuheApplicationTests {
	
	@Autowired
	ArticleService ArticleService;
	
	
	@Test
	public void testApproveArticle() {
		Article approveById=ArticleService.getById(1l);
		approveById.setApproval("false");
		ArticleService.save(approveById);
	}
	@Test
	public void testCreatePost() {
		Article article = new Article();
		article.setTitle("Trial 3");
		article.setContent("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" + 
				"tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" + 
				"quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" + 
				"consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\n" + 
				"cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\n" + 
				"proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
		ArticleService.save(article);
	}
	@Test
	public void testFindArticleById() {
		Article findById = ArticleService.getById(1l);
		System.out.println(findById);
	}
	
	@Test
	public void testDisplayAllArticles() {
		Iterable<Article> article = ArticleService.findAll();
		System.out.println(article.toString());
	}
	
	@Test
	public void testDeleteArticle() {
		Article article=new Article();
		article.setId(2l);
		ArticleService.delete(article);;
	}
		
}

