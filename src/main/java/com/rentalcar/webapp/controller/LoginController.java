package com.rentalcar.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rentalcar.webapp.service.UserService;

@Controller
@RequestMapping("/")
public class LoginController 
{
	  @Autowired
	  UserService userService;

	  @RequestMapping(value = "/loginform", method = RequestMethod.GET)
	  public ModelAndView showLogin() 
	  {
	    return new ModelAndView("login");
	  }
	  
	  @RequestMapping(value = "/loginform", method = RequestMethod.POST)
	  public ModelAndView loginProcess(@RequestParam("email") String email, @RequestParam("password") String password) 
	  {
	    ModelAndView mav = new ModelAndView();
	    boolean log = userService.authenticate(email, password);
	    
	    if (log != false) 
	    {
		    mav.setViewName("welcome");
		    mav.addObject("email", email);
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
	

