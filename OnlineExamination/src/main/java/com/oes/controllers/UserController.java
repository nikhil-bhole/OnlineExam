package com.oes.controllers;

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
    
    @RequestMapping(value = "/getQuestionsByCourseId", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Question> getQuestionsById(Model model) {
	   return questionsService.findAllByCourseId(2);
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
