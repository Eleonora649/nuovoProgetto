package com.rentalcar.webapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rentalcar.webapp.entities.User;
import com.rentalcar.webapp.service.UserService;

@Controller
@RequestMapping("/")
public class UserController 
{
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = {"/userregistration"}, method = RequestMethod.GET)
    public ModelAndView showForm() 
	{
        return new ModelAndView("registration-form", "user", new User());
    }
 
    @RequestMapping(value = {"/userregistration"}, method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result, ModelMap model) 
    {
    	if (result.hasErrors()) {
            return "registration-form";
        }

    	userService.saveUser(user);
    	return "success";
    }
    
    @RequestMapping(value = {"update-{id}-user"}, method = RequestMethod.GET)
    public String updateForm(@PathVariable int id, ModelMap model) 
    {
    	User user = userService.findUserById(id);
    	model.addAttribute("user", user);
    	model.addAttribute("update", true);
    	return "update-user";
    }
    
    @RequestMapping(value = {"update-{id}-user"}, method = RequestMethod.POST)
    public String updateUser(@Valid User user, BindingResult result, ModelMap mode, @PathVariable int id)
    {
    	if (result.hasErrors()) {
    		return "update-user";
    	}
    	userService.updateUser(user);
    	return "success";
    }

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String listUsers(ModelMap model) 
    {
    	List<User> users = userService.findAllUsers();
    	model.addAttribute("users", users);
    	return "allusers";
    }
    
    @RequestMapping(value = {"/delete-{id}-user"}, method = RequestMethod.GET)
    public String deleteUser(@PathVariable int id)
    {
    	userService.deleteUser(id);
    	return "redirect:/list";
    }
}
