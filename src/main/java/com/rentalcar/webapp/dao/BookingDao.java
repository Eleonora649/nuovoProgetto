package com.rentalcar.webapp.dao;

import java.sql.Date;
import java.util.List;

import com.rentalcar.webapp.entities.Booking;
import com.rentalcar.webapp.entities.Car;

public interface BookingDao 
{
	void saveBoo(Booking booking);
	
	void updateBoo(Booking booking);
	
	void delete(int id);
	
	List<Booking> findAll();
	
	Booking findBookingById(int id);
	
	List<Booking> findBookingExist(Car car, Date date);

}
