package com.rentalcar.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WelcomeController {
	
	@RequestMapping(value="home")
	public String getWelcome(Model model)
	{
		model.addAttribute("intestazione", "Rental Car");
		model.addAttribute("saluti", "Benvenuto");

		return "index";
	}
		
	@RequestMapping(value="")
	public String getIndex(Model model)
	{
		model.addAttribute("intestazione", "Rental Car");

		return "index";
	}
	
	
}
