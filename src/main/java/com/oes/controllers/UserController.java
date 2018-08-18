package com.oes.controllers;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.oes.entities.Question;
import com.oes.entities.Users;
import com.oes.services.QuestionService;
import com.oes.services.UsersService;

@RestController
@Controller
public class UserController {
	
	private UsersService usersService;
	private QuestionService questionsService;
	
	@Autowired
	public void setUsersService(UsersService userService) {
	        this.usersService = userService;
	}
	
	@Autowired
	public void setQuestionService(QuestionService questionService) {
	        this.questionsService = questionService;
	}
	
	@RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	/**
     *
     * @param model
     * @return
     */
    @RequestMapping("/sign-up")
    public ModelAndView newUser(Model model) {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.addObject("user", new Users());
    	modelAndView.setViewName("sign-up");
    	return modelAndView;
    }
    
    @RequestMapping(value = "/home", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView homey(Model model) {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.addObject("questions",questionsService.listAllQuestion());
    	modelAndView.setViewName("Home");
    	System.out.println("Returning questions:");
        return modelAndView;
    }
   
   @RequestMapping(value = "/getQuestions", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
   public List<Question> getQuestions(Model model) {
	   return questionsService.listAllQuestion();
	  
   }
    
    /**
     * Save user to database.
     *
     * @param product
     * @return
     */
    @RequestMapping(value = "saveuser", method = RequestMethod.POST)
    public String saveProduct(Users user) {
        usersService.save(user);
        return "login";
    }
   
    @RequestMapping(value="/users", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Users user = usersService.findByUserName(auth.getName());
		modelAndView.addObject("userName", "Welcome " + user.getFirstName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
		modelAndView.setViewName("users");
		return modelAndView;
	}
 }
