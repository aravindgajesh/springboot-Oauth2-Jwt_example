package com.ecofreeze.oauth2.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsersService implements UserDetailsService {

	@Autowired
	UsersDBQuery usersDBQuery;

	@Override
	public UserHelper loadUserByUsername(String userName) throws UsernameNotFoundException {

		UsersPojo userPojo = null;

		try {
			userPojo = usersDBQuery.getUserDetails(userName);
			UserHelper userDetail = new UserHelper(userPojo);
			return userDetail;
		} catch (Exception es) {
			es.printStackTrace();
			throw new UsernameNotFoundException("User Name " + userName + " Not found in APp");
		}

	}

}
