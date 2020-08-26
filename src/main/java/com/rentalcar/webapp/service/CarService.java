package com.rentalcar.webapp.service;

import java.util.List;

import com.rentalcar.webapp.entities.Car;

public interface CarService {

	void saveCar(Car car);
    
    void updateCar(Car car);
    
    void deleteCar(int id);
    
    Car findCarById(int id);
    
    List<Car> findAllCars(); 
}
