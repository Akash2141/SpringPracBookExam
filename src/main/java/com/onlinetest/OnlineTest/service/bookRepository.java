package com.onlinetest.OnlineTest.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinetest.OnlineTest.Entity.book;
@Repository
public interface bookRepository extends JpaRepository<book, Integer> {

}
