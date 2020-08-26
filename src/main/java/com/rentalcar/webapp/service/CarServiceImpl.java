package com.rentalcar.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rentalcar.webapp.dao.CarDao;
import com.rentalcar.webapp.entities.Car;

@Service("carService")
@Transactional 
public class CarServiceImpl implements CarService
{

	@Autowired
	private CarDao carDao;
	
	@Override
	public void saveCar(Car car) 
	{
		carDao.saveCar(car);
	}

	@Override
	public void updateCar(Car car) 
	{
		
	}

	@Override
	public void deleteCar(int id) 
	{
		carDao.deleteCar(id);
	}

	@Override
	public Car findCarById(int id) 
	{
		return carDao.findCarById(id);
	}

	@Override
	public List<Car> findAllCars() 
	{
		return carDao.findAllCars();
	}

}
