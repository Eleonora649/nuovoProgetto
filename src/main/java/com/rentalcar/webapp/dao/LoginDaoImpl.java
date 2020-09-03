package com.rentalcar.webapp.dao;

import org.springframework.stereotype.Repository;

import com.rentalcar.webapp.entities.UserEntity;

@Repository("loginDao")
public class LoginDaoImpl extends AbstractDao<Integer, UserEntity> implements LoginDao
{
	public UserEntity findUserByEmail(String email)
	{
		UserEntity user = null; 
		user = (UserEntity) getSession().createQuery("SELECT email FROM user WHERE email=:email")
				 .setParameter("email", email).uniqueResult(); 
		return user;
//		return getSession().get(UserEntity.class, email);
	}
}


