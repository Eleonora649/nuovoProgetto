package com.rentalcar.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WelcomeController {
	
	@RequestMapping(value="welcome")
	public String getWelcome(Model model)
	{
		model.addAttribute("intestazione", "Rental Car");
		model.addAttribute("saluti", "xxxxxxx");

		return "welcome";
	}
		
	@RequestMapping(value="index")
	public String getIndex(Model model)
	{
		model.addAttribute("intestazione", "Rental Car");

		return "index";
	}
	
	
}
