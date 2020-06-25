package com.genius7.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.genius7.model.User;
import com.genius7.rule.UserRule;

@Service
public class AuthenticationService implements UserDetailsService {

	@Autowired
	private UserRule userRule;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRule.findByEmail(username);
		if(user != null) {
			return user;
		}
		throw new UsernameNotFoundException("Dados incorretos para o login.");
	}

}
