package com.onlinetest.OnlineTest.controller;

import com.onlinetest.OnlineTest.service.*;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlinetest.OnlineTest.Entity.book;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BookResource {
	
	public static final Logger log=LoggerFactory.getLogger(BookResource.class);
	
	@Autowired
	service service;
	
	@PostMapping("/books")
	@ResponseBody
	public String postBook(@RequestBody book book) {
		service.insert(book);
		return "I am inserted";
		
	}
	
	@GetMapping("/books")
	@ResponseBody
	public List<book> getBook(){
		return service.getBook();
	}
	
	@GetMapping("/books/{id}")
	@ResponseBody
	public Optional<book> getSpecificBook(@PathVariable int id) {
		return service.getSpecificBook(id);
	}
	
	@DeleteMapping("/books/{id}")
	@ResponseBody
	public void delBook(@PathVariable int id) {
		
		service.delBook(id);
		log.info("Successfully deleted");
		
	}
	@PutMapping("/books")
	@ResponseBody
	public void upBook(@RequestBody book book) {
		
		service.upBook(book);
		log.info("Successfully updated");
		
	}

}
