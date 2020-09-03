package com.rentalcar.webapp.dao;

import com.rentalcar.webapp.entities.UserEntity;

public interface LoginDao 
{
	UserEntity findUserByEmail(String email);
}
