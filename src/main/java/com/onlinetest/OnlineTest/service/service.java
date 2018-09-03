package com.onlinetest.OnlineTest.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.onlinetest.OnlineTest.Entity.book;

@Repository
public class service {
	
	public static final Logger log=LoggerFactory.getLogger(service.class);
	
	@Autowired
	bookRepository bookRepo;
	
	public int insert(book book) {
		log.info("service " +book.getName());
		bookRepo.save(book);
		return book.getId();
	}
	
	public List<book> getBook() {
		List<book> books=new ArrayList<>();
		bookRepo.findAll().forEach(books::add);
		return books;
	}
	
	
}
