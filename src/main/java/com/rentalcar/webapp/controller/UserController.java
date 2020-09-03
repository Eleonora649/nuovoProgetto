package com.rentalcar.webapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rentalcar.webapp.entities.UserEntity;
import com.rentalcar.webapp.service.UserService;

@Controller
@RequestMapping("/")
public class UserController 
{
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = {"/userregistration"}, method = RequestMethod.GET)
    public ModelAndView showForm(Model model) 
	{
        return new ModelAndView("registration-form", "user", new UserEntity());
	}

    @RequestMapping(value = {"/userregistration"}, method = RequestMethod.POST)
    public String saveUser(@Valid @ModelAttribute("user") UserEntity user, 
    						BindingResult result, ModelMap model) 
    {
    	if (result.hasErrors()) 
    	{
            return "registration-form";
        }
    	
    	userService.saveUser(user);
    	return "success";
    }
    
    @RequestMapping(value = {"update/{id}"}, method = RequestMethod.GET)
    public ModelAndView updateForm(@PathVariable int id) 
    {
    	ModelAndView mav = new ModelAndView();
    	mav.addObject("user", userService.findUserById(id));
    	mav.setViewName("update-user");
    	return mav;
    }
    
    @RequestMapping(value = {"update/{id}"}, method = RequestMethod.POST)
    public ModelAndView updateUser(@PathVariable int id, @Valid UserEntity u, BindingResult result)
    {
    	ModelAndView mav = new ModelAndView();
    	if (result.hasErrors()) {
    		mav.setViewName("update-user");
    	}
    	userService.updateUser(u);
    	mav.setViewName("success");
    	return mav;
    }

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String listUsers(ModelMap model) 
    {
    	List<UserEntity> users = userService.findAllUsers();
    	model.addAttribute("users", users);
    	//model.addObject("users", userService.findAllUsers());
    	return "allusers";
    }
    
    @RequestMapping(value = {"/delete-{id}-user"}, method = RequestMethod.GET)
    public String deleteUser(@PathVariable int id)
    {
    	userService.deleteUser(id);
    	return "redirect:/list";
    }
}
