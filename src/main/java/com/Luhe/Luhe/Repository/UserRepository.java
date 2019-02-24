package com.Luhe.Luhe.Repository;

import org.springframework.data.repository.CrudRepository;

import com.Luhe.Luhe.security.User;

public interface UserRepository  extends CrudRepository<User, Long>{
	User findByUsername(String username);

}
