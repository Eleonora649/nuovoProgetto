package com.rentalcar.webapp.dao;

import java.util.List;

import com.rentalcar.webapp.entities.Category;

public interface CategoryDao 
{
	void addCategory(Category category);
	
	Category findByIdCategory(int idCat);
	
	Category findByNameCategory(String nameCat);
	
	List<Category> list();

}
