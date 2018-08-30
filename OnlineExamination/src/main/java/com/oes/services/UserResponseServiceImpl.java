package com.oes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oes.entities.UserResponse;
import com.oes.repositories.UserResponseRepository;


@Service
public class UserResponseServiceImpl implements UserResponseService{
	@Autowired
	private UserResponseRepository userResponseRepository;
	
	@Autowired
	public void setUserResponseRepository(UserResponseRepository userResponseRepository) {
	      this.userResponseRepository= userResponseRepository;
	}
	
	@Override
	public UserResponse save(UserResponse response) {
		return userResponseRepository.save(response);
	}
}
