package com.oes.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {
	
	@RequestMapping(value={"/","/login","/index"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@RequestMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {
        if (request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/admin/";
        }
        return "redirect:/user/";
    }
	
	@RequestMapping("/admin")
	public ModelAndView console(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("console");
		return modelAndView;
	}
	
	@RequestMapping("/user")
	public ModelAndView dashboard(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("dashboard");
		return modelAndView;
	}
	
}
