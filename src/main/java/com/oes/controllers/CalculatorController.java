package com.oes.controllers;


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
import com.oes.services.UserResponseService;

@RestController
public class CalculatorController {
	
	private UserResponseService userResponseService;
	
	@Autowired
	public void setQuestionService(UserResponseService userResponseService) {
	        this.userResponseService = userResponseService;
	}
	
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
	
	@PostMapping(path="/response")
	public String addNewKind(@RequestBody String response) throws Exception {
	    System.out.println(response);
	    UserResponse ur = new UserResponse();
	    ur.setUser_response(response);
	    userResponseService.save(ur);
	    return "Saved";
	}
}
