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
	
	@Column(name="course_id")
	private int course_id;
	
	@Column(name="user_id")
	private Integer user_id;
	
	public String getUser_response() {
		return user_response;
	}

	
	public void setUser_response(String user_response) {
		this.user_response = user_response;
	}
	
	
	public int getCourse_id() {
		return course_id;
	}


	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}


	public Integer getUser_id() {
		return user_id;
	}


	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}


}
