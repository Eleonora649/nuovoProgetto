package com.rentalcar.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class LoginController 
{
	@RequestMapping(value = "/loginform", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
							@RequestParam(value = "logout", required = false) String logout) {
 
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Utente o password non validi!");
		}
 
		if (logout != null) {
			model.addObject("message", "Logour eseguito con successo");
		}
		model.setViewName("login");
 
		return model;
	}
	
	@RequestMapping(value = {"/userPage"}, method = RequestMethod.GET)
	public ModelAndView userPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("userPage");
		return model;
	}
	
	@RequestMapping(value = {"/adminPage"}, method = RequestMethod.GET)
	public ModelAndView adminPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("adminPage");
		return model;
	}
}
