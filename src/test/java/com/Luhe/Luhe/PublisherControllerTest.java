package com.Luhe.Luhe;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.Luhe.Luhe.services.*;
import com.Luhe.Luhe.controllers.*;
import com.Luhe.Luhe.domains.*;

public class PublisherControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private ArticleService articleService;

	@InjectMocks
	private PublisherController publisherController;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);

		mockMvc = MockMvcBuilders.standaloneSetup(publisherController).build();
	}

	@Test
	public void testPublisherPage() throws Exception {
		mockMvc.perform(get("/publisher")).andExpect(status().isOk())

				.andExpect(view().name("Publisher"));
	}

	@Test
	public void testDisplayPublisher() throws Exception{
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
	public void testShowEachArticle() throws Exception{
		Long id=1l;
		
		
		when(articleService.getById(id)).thenReturn(new Article());
		
		mockMvc.perform(get("/publisher/eachView/1"))
		.andExpect(status().isOk())
		.andExpect(view().name("EachView"))
		.andExpect(model().attribute("article",instanceOf(Article.class)));
		
	}
	
	
	
	@Test
	public void testRejectArtile() throws Exception{
		Integer id=1;
		
		mockMvc.perform(post("/publisher/approveArticle/1"))
		.andExpect(status().is3xxRedirection())
		.andExpect(view().name("redirect:/publisher"));
		
		verify(articleService,times(1)).deleteById(1l);
	}
		
}
