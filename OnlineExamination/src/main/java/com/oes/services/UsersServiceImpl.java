package com.oes.services;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.oes.entities.Role;
import com.oes.entities.Users;
import com.oes.repositories.RoleRepository;
import com.oes.repositories.UsersRepository;


@Service
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
    private RoleRepository roleRepository;
    
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public void setUsersRepository(UsersRepository usersRepository) {
	      this.usersRepository= usersRepository;
	}
	 
	
	@Override
	public Users save(Users user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		return usersRepository.save(user);
	}
	

	public Iterable<Users> listAllProducts() {
		return usersRepository.findAll();
	}


	@Override
	public Users findByUsername(String username) {
		return usersRepository.findByUserName(username);
	}
	
	
	
	
}
