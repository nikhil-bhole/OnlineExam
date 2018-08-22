package com.oes.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User entity.
 */

@Entity
@Table(name="userresponse")
public class UserResponse {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="response_id")
	private int response_id;
	
	@Column(name="user_response")
	private String user_response;
	
	public String getUser_response() {
		return user_response;
	}

	public void setUser_response(String user_response) {
		this.user_response = user_response;
	}
}
