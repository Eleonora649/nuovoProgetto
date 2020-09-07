package com.rentalcar.webapp.controller;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.rentalcar.webapp.entities.UserEntity;
import com.rentalcar.webapp.service.UserService;

@SessionAttributes({"currentUser"})
@Controller
public class LoginController 
{
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }
	  
	@RequestMapping(value = "/do-login", method = RequestMethod.POST)
	public String loginProcess(@RequestParam("email") String email, @RequestParam("password") String password, 
									Model model, HttpSession session) 
	{
		UserEntity user = userService.authenticate(email, password);
		if(user==null)
		{
			return "/login";
		}
        session.setAttribute("user", user);
		System.out.println("login");
		return "redirect:home";
	}

	@RequestMapping(value = "/loginFailed", method = RequestMethod.GET)
	public String loginError(Model model) {
		model.addAttribute("error", "true");
		return "login";
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		SecurityContextHolder.getContext().setAuthentication(null);
		session.invalidate();
		return "redirect:/home";
	}

}
