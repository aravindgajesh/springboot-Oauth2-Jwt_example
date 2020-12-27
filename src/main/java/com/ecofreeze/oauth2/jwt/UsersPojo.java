package com.ecofreeze.oauth2.jwt;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class UsersPojo {

	private String userName;
	private String password;
	private Collection<GrantedAuthority> listOfGrantedAuthorities = new ArrayList<>();

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<GrantedAuthority> getListOfGrantedAuthorities() {
		return listOfGrantedAuthorities;
	}

	public void setListOfGrantedAuthorities(Collection<GrantedAuthority> listOfGrantedAuthorities) {
		this.listOfGrantedAuthorities = listOfGrantedAuthorities;
	}

}
