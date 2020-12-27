package com.ecofreeze.oauth2.jwt;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;

@Repository
public class UsersDBQuery {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public UsersPojo getUserDetails(String userName) {
		Collection<GrantedAuthority> listOfGrantedAuthorities = new ArrayList<>();
		String userQuery = "SELECT * FROM USERS WHERE USERNAME=?";

		List<UsersPojo> usersList = jdbcTemplate.query(userQuery, new String[] { userName },
				(ResultSet rs, int rowNum) -> {

					UsersPojo user = new UsersPojo();
					user.setUserName(userName);
					user.setPassword(rs.getString("PASSWORD"));
					return user;
				});
		
		if(usersList != null && usersList.size()>0) {
			GrantedAuthority grantedAuthority =  new SimpleGrantedAuthority("ROLE_SYSTEMADMIN");
			listOfGrantedAuthorities.add(grantedAuthority);
			usersList.get(0).setListOfGrantedAuthorities(listOfGrantedAuthorities);
			return usersList.get(0);
		}
		return null;
	}
}
