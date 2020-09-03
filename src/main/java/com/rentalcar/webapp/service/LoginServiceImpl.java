package com.rentalcar.webapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentalcar.webapp.dao.LoginDao;
import com.rentalcar.webapp.entities.UserEntity;

@Service("loginService")
public class LoginServiceImpl
{
	@Autowired
	private LoginDao loginDao;

	public UserEntity authenticate(String email, String password) 
	{ 
		UserEntity user = loginDao.findUserByEmail(email);
		if(!(user!=null && user.getEmail().contentEquals(email) &&
				user.getPassword().equals(password))) 
		{ 
			user = null; 
		} 
		return user; 
	}
}
