package com.oes.services;



import com.oes.entities.Users;

public interface UsersService {
	Users save(Users user);
	Iterable<Users> listAllProducts();
	Users findByUserName(String userName);
}
