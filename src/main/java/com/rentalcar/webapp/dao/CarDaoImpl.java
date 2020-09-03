package com.rentalcar.webapp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.query.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.rentalcar.webapp.entities.Car;
import com.rentalcar.webapp.entities.Category;

@Repository("carDao")
public class CarDaoImpl extends AbstractDao<Integer, Car> implements CarDao
{
	@Override
	public void saveCar(Car car) 
	{
		persist(car);
	}

	@Override
	public void updateCar(Car car) 
	{
		updateCar(car);
	}

	@Override
	public void deleteCar(int id) 
	{
		Query query = getSession().createSQLQuery("delete from User where id_car=:id");
		query.setInteger("id", id);
		query.executeUpdate();
	}

	@Override
	public Car findCarById(int id) 
	{
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("id", id));
		return (Car) criteria.uniqueResult();
	}

	@Override
	public List<Car> findAllCars() 
	{
		Criteria criteria = createEntityCriteria();
		return (List<Car>) criteria.list();
	}

}
