package com.rentalcar.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentalcar.webapp.dao.CategoryDao;
import com.rentalcar.webapp.entities.Category;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService
{
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public void addCategory(Category category) 
	{
		categoryDao.addCategory(category);
	}

	@Override
	public List<Category> list() 
	{
		return categoryDao.list();
	}

	@Override
	public Category findByIdCategory(int idCat) 
	{
		return categoryDao.findByIdCategory(idCat);
	}

	@Override
	public Category findByNameCategory(String nameCat) 
	{
		return categoryDao.findByNameCategory(nameCat);
	}

}
