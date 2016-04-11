package com.books_analyzer.controller;

import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.books_analyzer.service.BooksProcessor;
import org.springframework.web.client.RestTemplate;

@RestController
public class SearchController {
	BooksProcessor booksProcessor;

	@RequestMapping(value = "/search", method = { RequestMethod.GET })
	public String search(
			@RequestParam(value = "title", required=false) String title,
			@RequestParam(value = "author", required=false) String author,
			@RequestParam(value = "character", required=false) String character,
			@RequestParam(value = "url", required=false) String url
	)  {

		System.out.println("SeachController: The parameters received are-");
		//System.out.println("SeachController: " + String.join(",", title, author, character, url));
		//System.out.println("SeachController: " + String.join(",", title, author, character));
    	/*booksProcessor = new BooksProcessor(title, author, character, url);
    	booksProcessor.process();
    	return booksProcessor.getJSON();*/
/*
		Map <String, String> vars = new HashMap<String, String>();
		vars.put("title",title);
		vars.put("author",author);
		vars.put("character",character);
		vars.put("url",url);*/
RestTemplate restTemplate = new RestTemplate();
		//		restTemplate.getForObject("http://example.com/hotels/{hotel}/bookings/{booking}", String.class,title,author,character,url);
		//return restTemplate.getForObject("https://book-analyzer.herokuapp.com/", String.class,title,author,character,url);
		return restTemplate.getForObject("https://book-analyzer.herokuapp.com/search/", String.class,title,author,character,url);
	}
}