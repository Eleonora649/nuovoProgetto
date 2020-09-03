package com.rentalcar.webapp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.rentalcar.webapp.entities.Category;

@Transactional
@Repository("categoryDao")
public class CategoryDaoImpl extends AbstractDao<Integer, Category> implements CategoryDao
{

	@Override
	public void addCategory(Category category) 
	{
		persist(category);
	}

	@Override
	public List<Category> list() 
	{
		Criteria criteria = createEntityCriteria();
		return (List<Category>) criteria.list();
//		return findAll();
	}

	@Override
	public Category findByIdCategory(int idCat) 
	{
		Query query = getSession().createQuery("FROM Category WHERE id_category=:idCat");
		query.setParameter("idCat", idCat);
		return (Category) query.getSingleResult();
	}

	@Override
	public Category findByNameCategory(String nameCat) 
	{
		Query query = getSession().createQuery("FROM Category WHERE name=:nameCat");
		query.setParameter("nameCat", nameCat);
		return (Category) query.getSingleResult();
	}

}
