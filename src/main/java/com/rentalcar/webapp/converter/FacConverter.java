//package com.rentalcar.webapp.converter;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.stereotype.Component;
//
//import com.rentalcar.webapp.entities.Category;
//import com.rentalcar.webapp.service.CategoryService;
//
//@Component("facConverter")
//public class FacConverter implements Converter<String, Category>
//{
//
//	@Autowired
//	private CategoryService categoryService;
//	
//	@Override
//	public Category convert(String categ) 
//	{
//		return categoryService.findByIdCategory(Integer.parseInt(categ));
//	}
//
//}
