package com.rentalcar.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rentalcar.webapp.entities.User;
import com.rentalcar.webapp.service.UserServiceImpl;

@Controller
@RequestMapping("/")
public class RegistrationUserController {

	@Autowired
	public UserServiceImpl userService;
	
	
	@RequestMapping(value = "/register-form", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user") User user) {
		
		ModelAndView mav = new ModelAndView("register-form");

		userService.saveUser(user);
		return mav;
	}


}
