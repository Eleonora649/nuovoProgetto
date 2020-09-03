package com.rentalcar.webapp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.query.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.rentalcar.webapp.entities.Car;

@Repository("carDao")
@Transactional
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
		Query query = getSession().createSQLQuery("delete from car where id_car=:id");
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
