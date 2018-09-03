package com.onlinetest.OnlineTest.controller;

import com.onlinetest.OnlineTest.service.*;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlinetest.OnlineTest.Entity.book;

@RestController
@Controller
public class BookResource {
	
	public static final Logger log=LoggerFactory.getLogger(BookResource.class);
	
	@Autowired
	service service;
	
	@PostMapping("/books")
	public String postBook(@RequestBody book book) {
		log.info(book.getName()+" hii");
		service.insert(book);
		return "I am inserted";
		
	}
	
	@GetMapping("/books")
	public List<book> getBook(){
		return service.getBook();
	}
 

}
