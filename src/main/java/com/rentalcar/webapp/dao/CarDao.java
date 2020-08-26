package com.rentalcar.webapp.dao;

import java.util.List;

import com.rentalcar.webapp.entities.Car;

public interface CarDao {

	void saveCar(Car car);
	
	void updateCar(Car car);
	
	void deleteCar(int id);
	
	Car findCarById(int id);
	
	List<Car> findAllCars();
}
