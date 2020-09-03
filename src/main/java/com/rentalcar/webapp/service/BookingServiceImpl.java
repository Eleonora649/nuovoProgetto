package com.rentalcar.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentalcar.webapp.dao.BookingDao;
import com.rentalcar.webapp.entities.Booking;

@Service("bookingService")
public class BookingServiceImpl implements BookingService
{
	@Autowired
	private BookingDao bookingDao;

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBooking() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Booking> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Booking findBookingById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
