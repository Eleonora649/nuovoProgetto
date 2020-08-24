package com.rentalcar.webapp.dao;

import java.util.List;

import com.rentalcar.webapp.entities.User;

public interface UserDao 
{
	void saveUser(User user);
	
	void update(User user);
	
	void deleteUser(int id);
	
	User findUserById(int id);
	
	List<User> findAllUsers();
	
}
