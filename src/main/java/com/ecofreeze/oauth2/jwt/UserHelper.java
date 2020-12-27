package com.ecofreeze.oauth2.jwt;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UserHelper extends User {

	public UserHelper(UsersPojo users) {
		super(users.getUserName(), users.getPassword(), users.getListOfGrantedAuthorities()

		);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
