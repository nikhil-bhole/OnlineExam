package com.oes.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.oes.entities.Users;
import com.oes.services.UsersService;

@Controller
public class UserController {
	
	private UsersService usersService;
	
	@Autowired
	public void setUsersService(UsersService userService) {
	        this.usersService = userService;
	}
	
	@RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	/**
     * New user.
     *
     * @param model
     * @return
     */
    @RequestMapping("/sign-up")
    public String newUser(Model model) {
        model.addAttribute("user", new Users());
        return "sign-up";
    }
    
    
	/**
     * Save user to database.
     *
     * @param product
     * @return
     */
    @RequestMapping(value = "saveuser", method = RequestMethod.POST)
    public String saveProduct(Users user) {
        System.out.println(user.getFirstName() + user.getLastName()+user.getEmail()+user.getUserName()+user.getPassword());
    	usersService.save(user);
        return "login";
    }
    
    /**
     * List all products.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/get_all_users", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("users", usersService.listAllProducts());
        System.out.println("Returning users:");
        return "users";
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
