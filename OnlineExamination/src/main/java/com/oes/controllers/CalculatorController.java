package com.oes.controllers;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oes.entities.UserResponse;
import com.oes.entities.Users;
import com.oes.services.UserResponseService;

@RestController
public class CalculatorController {
	
	
	
	@RequestMapping(value="/square/{number}",method=RequestMethod.POST)
	public int calculateSquare(@PathVariable int number) {
		return number*number;
	}
	
	/*@RequestMapping(value = "/response", method = RequestMethod.POST )
    public String createUser(@RequestBody UserResponse response) {
		System.out.println(response);
		userResponseService.save(response);
		return "done";
    }*/
	
	
	
	
}
