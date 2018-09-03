package com.oes.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.oes.entities.UserResponse;
import com.oes.entities.Users;
import com.oes.services.UserResponseService;
import com.oes.services.UsersService;

@Controller
public class WebController {
	
	private UsersService usersService;
	private UserDetails userDetails;
	private Users user;
	
	@Autowired
	public void setUsersService(UsersService userService) {
	        this.usersService = userService;
	}
	
	private UserResponseService userResponseService;
	
	@Autowired
	public void setQuestionService(UserResponseService userResponseService) {
	        this.userResponseService = userResponseService;
	}
	
	@RequestMapping(value={"/","/login","/index"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@RequestMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {
        if (request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/admin";
        }else {
        	return "redirect:/user";
        }
    }
	
	@RequestMapping("/admin")
	public ModelAndView console(Principal principal){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("console");
		String username = principal.getName();
		Users u = usersService.findByUserName(username);
		modelAndView.addObject("username", username);
	    modelAndView.addObject("userId", u.getId());
		return modelAndView;
	}
	
	
	@RequestMapping("/user")
	public ModelAndView dashboard(Principal principal){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("dashboard");
		String username = principal.getName();
		Users u = usersService.findByUserName(username);
		modelAndView.addObject("username", username);
	    modelAndView.addObject("userId", u.getId());
		return modelAndView;
	}
	
	@PostMapping(path="/response")
	public String addNewKind(@RequestBody String response, Principal principal) throws Exception {
		String username = principal.getName();
		Users u = usersService.findByUserName(username);
		Integer user_id = u.getId();
	    UserResponse ur = new UserResponse();
	    ur.setUser_response(response);
	    ur.setUser_id(user_id);
	    ur.setCourse_id(1);
	    userResponseService.save(ur);
	    return "redirect:/user";
	}
	
}
