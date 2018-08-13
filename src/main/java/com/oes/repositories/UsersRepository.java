package com.oes.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.oes.entities.Users;

@Repository("usersRepository")
public interface UsersRepository extends CrudRepository<Users, Integer>{
	Users findByUserName(String userName);
}
