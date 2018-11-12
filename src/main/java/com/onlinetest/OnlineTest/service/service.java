package com.onlinetest.OnlineTest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.onlinetest.OnlineTest.Entity.book;

@Service
public class service implements UserDetailsService{
	
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

	public Optional<book> getSpecificBook(int id) {
		
		return bookRepo.findById(id);
	}
	
	public void delBook(int id) {
		bookRepo.deleteById(id);
		log.info("Deleted");
	}

	public void upBook(book book) {
		bookRepo.save(book);
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
}
