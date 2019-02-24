package com.Luhe.Luhe;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.Luhe.Luhe.controllers.ArticleController;
import com.Luhe.Luhe.domains.Article;
import com.Luhe.Luhe.services.ArticleService;




public class ArticleControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private ArticleService articleService;

	@InjectMocks
	private ArticleController articlecontroller;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);

		mockMvc = MockMvcBuilders.standaloneSetup(articlecontroller).build();
	}

	@Test
	public void testArticlePage() throws Exception {
		mockMvc.perform(get("/Article/current")).andExpect(status().isOk())

				.andExpect(view().name("Article"));
	}
	
	@Test
	public void testArticleFormView() throws Exception{
		Long id=1l;
		
		
		verifyZeroInteractions(articleService);
		
		mockMvc.perform(get("/Article/form"))
		.andExpect(status().isOk())
		.andExpect(view().name("ArticleForm"))
		.andExpect(model().attribute("articles",instanceOf(Article.class)));
	}

	@Test
	public void testDisplayArticleForm() throws Exception{
		List<Article> articles = new ArrayList<>();
		articles.add(new Article());
		articles.add(new Article());

		when(articleService.findAll()).thenReturn((List<Article>) articles);

		mockMvc.perform(get("/publisher"))
				.andExpect(status().isOk())
				.andExpect(view().name("publisher"))
				.andExpect(model().attribute("articles",null));

	}
	
	@Test
	public void testEachArticleView() throws Exception{
		Long id=1l;
		
		
		when(articleService.getById(id)).thenReturn(new Article());
		
		mockMvc.perform(get("/Article/each/1"))
		.andExpect(status().isOk())
		.andExpect(view().name("EachViewArticle"))
		.andExpect(model().attribute("article",instanceOf(Article.class)));
		
	}
	
	@Test
	public void testShowEditForm() throws Exception {
		Long id=1l;
		
		when(articleService.getById(id)).thenReturn(new Article());
		
		mockMvc.perform(get("/Article/editForm/1"))
		.andExpect(status().isOk())
		.andExpect(view().name("EachViewArticle"))
		.andExpect(model().attribute("article",instanceOf(Article.class)));
	}
	/*
	@Test
	public void testSaveArticle() throws Exception{
		Long id=1l;
		String title="Test Approval";
		String content="Approval description";
		String Approval="false";
		Date createdAt=new Date();
		
		Article approveArticles=new Article();
		approveArticles.setId(id);
		approveArticles.setTitle(title);
		approveArticles.setContent(content);
		approveArticles.setApproval(Approval);
		approveArticles.setCreatedAt(createdAt);
		
		when(articleService.save((Article) Matchers.<Article>any(null))).thenReturn(approveArticles);
		
		
		
		 mockMvc.perform(post("/Article"))
		.param("id",1l)
		.param("title","1")
		.param("content",content)
		.param("Approval","false")
		.param(createdAt,new Date())
		
		.andExpect(status().is3xxRedirection())
		.andExpect(view().name("redirect:/Article/current"))
		.andExpect(model().attribute("article",instanceOf(Article.class)))
		;
	
	ArgumentCaptor<Article> boundArticle=ArgumentCaptor.forClass(Article.class);
	verify(articleService).save(boundArticle.capture());
	
	assertEquals(id,boundArticle.getValue().getId());
	assertEquals(title,boundArticle.getValue().getTitle());
	assertEquals(content,boundArticle.getValue().getContent());
	assertEquals(Approval,boundArticle.getValue().getApproval());
	assertEquals(createdAt,boundArticle.getValue().getCreatedAt());
	}*/
	
	@Test
	public void testDeleteArtile() throws Exception{
		Integer id=1;
		
		mockMvc.perform(post("/publisher/approveArticle/1"))
		.andExpect(status().is3xxRedirection())
		.andExpect(view().name("redirect:/Article/current"));
		
		verify(articleService,times(1)).deleteById(1l);
	}
		
}
