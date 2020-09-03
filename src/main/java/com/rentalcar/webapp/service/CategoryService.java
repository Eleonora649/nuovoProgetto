package com.rentalcar.webapp.service;

import java.util.List;

import com.rentalcar.webapp.entities.Category;

public interface CategoryService 
{
	void addCategory(Category category);
	
	List<Category> list();
	
	Category findByIdCategory(int idCat);
	
	Category findByNameCategory(String nameCat);
	
}
