package com.onlinetest.OnlineTest.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class book {
	
	@Id
	@GeneratedValue
	int id;
	String name;
	public book() {
		super();
	}
	public book(String name) {
		super();
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
}
