package com.rentalcar.webapp.controller;

import javax.validation.Valid;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rentalcar.webapp.entities.Booking;

public class BookingController 
{
	@RequestMapping(value = {"booking/{id}/car"}, method = RequestMethod.GET)
	public ModelAndView showBook(@PathVariable int id, ModelMap model)
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("booking");
		return mav;
	}
	
	@RequestMapping(value = {"booking/{id}/car"}, method = RequestMethod.POST)
	public ModelAndView startBooking(@PathVariable int id, @Valid @ModelAttribute("booking") Booking book, BindingResult result)
	{
		return new ModelAndView("booking", "book", new Booking());
	}
}
