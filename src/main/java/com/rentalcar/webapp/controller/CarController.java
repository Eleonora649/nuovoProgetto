package com.rentalcar.webapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rentalcar.webapp.data.CarData;
import com.rentalcar.webapp.entities.Booking;
import com.rentalcar.webapp.entities.Car;
import com.rentalcar.webapp.entities.Category;
import com.rentalcar.webapp.entities.UserEntity;
import com.rentalcar.webapp.service.CarService;
import com.rentalcar.webapp.service.CategoryService;

@Controller
@RequestMapping("/")
public class CarController 
{
	@Autowired
	private CarService carService;

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = {"/addcar"}, method = RequestMethod.GET)
	public String showForm(ModelMap model)
	{
		model.addAttribute("car", new Car());
		List<Category> listCategory = categoryService.list();
		model.addAttribute("listCategory", listCategory);
		return "add-car";
	}
	
	@RequestMapping(value = {"/addcar"}, method = RequestMethod.POST)
	public String saveCar(@Valid @ModelAttribute("car") CarData carData,
							BindingResult result, ModelMap model)
	{
		if(result.hasErrors()) 
		{
			List<Category> listCategory = categoryService.list();
			model.addAttribute("listCategory", listCategory);
			return "add-car";
		}

		carService.saveCar(carData);
		return "success";
	}

	@RequestMapping(value = {"/listcar"}, method = RequestMethod.GET)
	public String listCars(ModelMap model)
	{
		List<Car> cars = carService.findAllCars();
		model.addAttribute("cars", cars);
		return "all-cars";
	}

	@RequestMapping(value = {"/delete/{id}/car"}, method = RequestMethod.GET)
	public String deleteCar(@PathVariable int id)
	{
		carService.deleteCar(id);
		return "redirect:/listcar";
	}

	@RequestMapping(value = {"/update/{id}/car"}, method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable int id, ModelMap model)
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("car", carService.findCarById(id));
		List<Category> listCategory = categoryService.list();
		mav.addObject("listCategory", listCategory);
		mav.setViewName("update-car");
		return mav;
	}
	
	@RequestMapping(value = {"update/{id}/car"}, method = RequestMethod.POST)
    public ModelAndView updateCar(@PathVariable int id, @Valid @ModelAttribute CarData carData, BindingResult result, ModelMap model)
    {
		ModelAndView mav = new ModelAndView();
    	
		if (result.hasErrors()) 
    	{
    		List<Category> listCategory = categoryService.list();
			model.addAttribute("listCategory", listCategory);
    		mav.setViewName("update-car");
    	}
    	
    	carService.updateCar(carData);
    	mav.setViewName("success");
    	return mav;
    }

}
