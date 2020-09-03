package com.rentalcar.webapp.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rentalcar.webapp.entities.UserEntity;

@Repository("userDetailsDao")
public class UserDetailsDaoImpl implements UserDetailsDao
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public UserEntity findUserByEmail(String email) 
	{
		return sessionFactory.getCurrentSession().get(UserEntity.class, email);
	}
	
}
