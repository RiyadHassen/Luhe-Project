package com.Luhe.Luhe.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.Luhe.Luhe.security.User;



public interface UserService extends UserDetailsService {

	User findUserByUsername(String username);
	void saveUser(User user);
	
}
