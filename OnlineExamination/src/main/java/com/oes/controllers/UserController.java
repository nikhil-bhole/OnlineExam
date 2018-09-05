package com.oes.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	private List<Question> questions = new ArrayList();
	
	@Autowired
	public void setUsersService(UsersService userService) {
	        this.usersService = userService;
	}
	
	@Autowired
	public void setQuestionService(QuestionService questionService) {
	        this.questionsService = questionService;
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


    @RequestMapping(value = "/setTest", method = RequestMethod.POST)
    public ModelAndView handlePostRequest(Model model,@RequestParam(name="selectSubject") int selectSubject) {
    	ModelAndView modelAndView = new ModelAndView();
    	questions = questionsService.findAllByCourseId(selectSubject);
    	modelAndView.addObject("user", "user");
    	modelAndView.setViewName("Home");
    	return modelAndView;
    }
    
    
    @RequestMapping(value = "/getQuiz", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Question> handleGetRequest(Model model) {
        return questions;
    }
    
    
     /**
     * Save user to database.
     *
     * @param user
     * @return
     */
    
    @RequestMapping(value = "saveuser", method = RequestMethod.POST)
    public String saveProduct(Users user) {
        usersService.save(user);
        return "login";
    }
    
    
   
 }
