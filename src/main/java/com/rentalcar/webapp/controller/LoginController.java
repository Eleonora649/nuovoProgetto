package com.rentalcar.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rentalcar.webapp.entities.Login;
import com.rentalcar.webapp.entities.UserEntity;
import com.rentalcar.webapp.service.UserService;

@Controller
@RequestMapping("/")
public class LoginController 
{
	@Autowired
	  UserService userService;
	
	  @RequestMapping(value = "/loginform", method = RequestMethod.GET)
	  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) 
	  {
	    ModelAndView mav = new ModelAndView("login");
	    mav.addObject("login", new Login());
	    return mav;
	  }
	  
	  @RequestMapping(value = "/loginform", method = RequestMethod.POST)
	  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
			  					@ModelAttribute("login") Login login, @PathVariable String email) 
	  {
	    ModelAndView mav = new ModelAndView();
	    UserEntity user = userService.findUserByEmail(email);
	    
	    if (null != user) 
	    {
		    mav.setViewName("welcome");
		    mav.addObject("email", user.getEmail());
		} 
	    else 
	    {
			mav.setViewName("login");
			mav.addObject("message", "Username or Password is wrong!!");
	    }
	    
	    return mav;
	  }
	    	

}
	
//	@Autowired
//	private UserService userService;
//	
//	@RequestMapping(value = "/loginform", method = RequestMethod.GET)
//	public String login(@Valid @ModelAttribute("user") UserEntity user, String email, String password, 
//							Model model, String error, String logout) 
//	{
////		model.addAttribute("user", userService.authenticate(email, password));
//		model.addAttribute("email",user.getEmail());
//		model.addAttribute("password", user.getPassword());
//		if (error != null)
//			model.addAttribute("error", "Your username and password is invalid.");
//
//		if (logout != null)
//			model.addAttribute("message", "You have been logged out successfully.");
//		
//		return "login";
//	}
//	
//	@RequestMapping(value = "/loginform", method = RequestMethod.POST)
//	public String login()
//	{
//		return "login";
//	}
	

