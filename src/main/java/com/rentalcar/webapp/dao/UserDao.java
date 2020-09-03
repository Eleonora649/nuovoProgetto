package com.rentalcar.webapp.dao;

import java.util.List;

import com.rentalcar.webapp.entities.Login;
import com.rentalcar.webapp.entities.UserEntity;

public interface UserDao 
{
	void saveUser(UserEntity user);
	
	void updateUser(UserEntity user);
	
	void deleteUser(int id);
	
	UserEntity findUserById(int id);
	
	List<UserEntity> findAllUsers();
	
	UserEntity findByEmail(String email);

	boolean checkLogin(String email, String password);

	UserEntity validateUser(Login login);

}
