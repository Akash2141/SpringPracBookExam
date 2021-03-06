package com.onlinetest.OnlineTest.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.onlinetest.OnlineTest.Entity.book;

public class bookDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private book book;
	
	public bookDetailsImpl(book book) {
		super();
		this.book = book;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return book.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return book.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
