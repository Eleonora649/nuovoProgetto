package com.rentalcar.webapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentalcar.webapp.dao.RoleDao;
import com.rentalcar.webapp.dao.UserDao;
import com.rentalcar.webapp.entities.Role;
import com.rentalcar.webapp.entities.UserEntity;

@Service("userService")
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Override
	public void saveUser(UserEntity user) 
	{
//		UserEntity us = new UserEntity();
    	Role role = roleDao.findByIdRole(2);
    	List<Role> roles = new ArrayList<Role>();
    	roles.add(role);
    	user.setRoles(roles);
    	userDao.saveUser(user);
	}

	@Override
	public void updateUser(UserEntity user) 
	{
		UserEntity entity = userDao.findUserById(user.getIdUser());
        if(entity!=null)
        {
            entity.setName(user.getName());
            entity.setSurname(user.getSurname());
            entity.setDateOfBirth(user.getDateOfBirth());
            entity.setEmail(user.getEmail());
            entity.setPassword(user.getPassword());
        }
		userDao.updateUser(entity);
	}

	@Override
	public void deleteUser(int id) 
	{
		userDao.deleteUser(id);
	}

	@Override
	public UserEntity findUserById(int id) 
	{
		return userDao.findUserById(id);
	}

	@Override
	public List<UserEntity> findAllUsers() 
	{
		return userDao.findAllUsers();
	}

	@Override
	public UserEntity findUserByEmail(String email) 
	{
		UserEntity user = userDao.findByEmail(email);
		return user;
	}

	@Override
	public UserEntity authenticate(String email, String password) 
	{
		UserEntity user = userDao.checkLogin(email);

		if(!(user!=null && user.getEmail().equals(email) && user.getPassword().equals(password)))
		{
				user = null;
		}
		
		return user;
	}
	
}
