package com.rentalcar.webapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rentalcar.webapp.entities.Car;
import com.rentalcar.webapp.service.CarService;

@Controller
@RequestMapping("/")
public class CarController 
{
	@Autowired
	private CarService carService;

	@RequestMapping(value = {"/addcar"}, method = RequestMethod.GET)
	public ModelAndView showForm()
	{
		return new ModelAndView("add-car", "car", new Car());
	}
	
	@RequestMapping(value = {"/addcar"}, method = RequestMethod.POST)
	public String saveCar(@Valid Car car, BindingResult result, ModelMap model)
	{
		carService.saveCar(car);
		return "add-car";
	}

	@RequestMapping(value = {"/listcar"}, method = RequestMethod.GET)
	public String listCars(ModelMap model)
	{
		List<Car> cars = carService.findAllCars();
		model.addAttribute("cars", cars);
		return "all-cars";
	}

	@RequestMapping(value = {"/delete-{id}-car"}, method = RequestMethod.GET)
	public String deleteCar(@PathVariable int id)
	{
		carService.deleteCar(id);
		return "redirect:/listcar";
	}
}
