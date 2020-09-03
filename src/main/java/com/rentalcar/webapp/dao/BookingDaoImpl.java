package com.rentalcar.webapp.dao;

import java.sql.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.rentalcar.webapp.entities.Booking;
import com.rentalcar.webapp.entities.Car;
import com.rentalcar.webapp.entities.UserEntity;

@Repository("bookingDao")
public class BookingDaoImpl extends AbstractDao<Integer, Booking> implements BookingDao
{

	@Override
	public void saveBoo(Booking booking) 
	{
		persist(booking);
	}

	@Override
	public void updateBoo(Booking booking) 
	{
		update(booking);
	}

	@Override
	public void delete(int id) 
	{
		Query query = getSession().createQuery("delete from booking where id_booking=:id");
		query.setInteger("id", id);
		query.executeUpdate();
	}

	@Override
	public List<Booking> findAll() 
	{
		Criteria criteria = createEntityCriteria();
		return (List<Booking>) criteria.list();
	}

	@Override
	public Booking findBookingById(int id) 
	{
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("id",id));
		return (Booking) criteria.uniqueResult();
	}

	@Override
	public List<Booking> findBookingExist(Car car, Date date) 
	{
		List<Booking> boo = (List<Booking>) getSession().createQuery("FROM booking WHERE DATE(CURDATE())<=:date and id_car=:idCar")
					.setParameter("idCar", car.getIdCar())
					.setParameter("date", date).getResultList();
		return boo;
	}

}
