package com.oes.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.oes.entities.UserResponse;

@Repository("userResponseRepository")
public interface UserResponseRepository extends CrudRepository<UserResponse, Integer>{

}
