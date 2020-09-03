package com.rentalcar.webapp.service;

import java.util.List;

import com.rentalcar.webapp.entities.Booking;

public interface BookingService 
{
	void save();
	//Booking save(String startBooking, String endOfBooking, UserEntity user, Car car);
	
	void updateBooking();
	//void updateBooking(int id, String startBooking, String endOfBooking, user, car);
	
	void delete(int id);
	
	List<Booking> listAll();
	
	Booking findBookingById(int id);
}
