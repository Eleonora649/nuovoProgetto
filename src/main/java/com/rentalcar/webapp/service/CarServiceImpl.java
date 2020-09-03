package com.rentalcar.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestPart;

import com.rentalcar.webapp.dao.CarDao;
import com.rentalcar.webapp.dao.CategoryDao;
import com.rentalcar.webapp.data.CarData;
import com.rentalcar.webapp.entities.Car;
import com.rentalcar.webapp.entities.Category;

@Service("carService")
@Transactional 
public class CarServiceImpl implements CarService
{
	@Autowired
	private CarDao carDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public void saveCar(CarData carData) 
	{
		Category cat = categoryDao.findByIdCategory(carData.getCategory());
		Car car =  new Car(carData, cat);
		carDao.saveCar(car);
	}

	@Override
	public void updateCar(CarData car) 
	{
		Category cat = categoryDao.findByIdCategory(car.getCategory());
		Car carU = carDao.findCarById(cat.getIdCategory());
        if(carU!=null)
        {
        	carU.setCarLicensePlate(car.getCarLicensePlate());
            carU.setManufacturer(car.getManufacturer());
            carU.setYearOfRegistration(car.getYearOfRegistration());
            carU.setCarModel(car.getCarModel());
//            carU.setCategory(car.getCategory());
        }
		carDao.updateCar(carU);
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
