package com.rentalcar.webapp.dao;

import com.rentalcar.webapp.entities.UserEntity;

public interface UserDetailsDao 
{
	UserEntity findUserByEmail(String email);
}
