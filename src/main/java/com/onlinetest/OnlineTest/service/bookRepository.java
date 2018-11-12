package com.onlinetest.OnlineTest.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.onlinetest.OnlineTest.Entity.book;
@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface bookRepository extends JpaRepository<book, Integer> {

}
