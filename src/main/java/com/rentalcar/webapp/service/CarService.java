package com.rentalcar.webapp.service;

import java.util.List;

import com.rentalcar.webapp.data.CarData;
import com.rentalcar.webapp.entities.Car;

public interface CarService {

	void saveCar(CarData car);
    
    void updateCar(CarData car);
    
    void deleteCar(int id);
    
    Car findCarById(int id);
    
    List<Car> findAllCars(); 
}
