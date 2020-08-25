package com.rentalcar.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rentalcar.webapp.dao.UserDao;
import com.rentalcar.webapp.entities.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserDao userDao;
	
	@Override
	public void saveUser(User user) 
	{
		userDao.saveUser(user);
	}

	@Override
	public void updateUser(User user) 
	{
		User entity = userDao.findUserById(user.getIdUser());
        if(entity!=null)
        {
            entity.setName(user.getName());
            entity.setSurname(user.getSurname());
            entity.setDateOfBirth(user.getDateOfBirth());
            entity.setEmail(user.getEmail());
            entity.setPassword(user.getPassword());
        }
		
	}

	@Override
	public void deleteUser(int id) 
	{
		userDao.deleteUser(id);
	}

	@Override
	public User findUserById(int id) 
	{
		return userDao.findUserById(id);
	}

	@Override
	public List<User> findAllUsers() 
	{
		return userDao.findAllUsers();
	}
	
}
