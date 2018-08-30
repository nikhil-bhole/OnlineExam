package com.oes.services;



import org.springframework.data.jpa.repository.Query;

import com.oes.entities.Users;

public interface UsersService {
	Users save(Users user);
	Iterable<Users> listAllProducts();
	
	//@Query("select u from Users u where u.username = :username")
	Users findByUsername(String username);
	
}
