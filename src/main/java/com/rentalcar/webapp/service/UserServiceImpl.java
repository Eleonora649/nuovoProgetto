package com.rentalcar.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rentalcar.webapp.dao.UserDao;
import com.rentalcar.webapp.entities.UserEntity;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserDao userDao;
	
	@Override
	public void saveUser(UserEntity user) 
	{
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
		userDao.update(entity);
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

//	@Override
//	public UserEntity findByEmail(String email) {
//		UserEntity user = userDao.findByEmail(email);
//		return user;
//	}
//	
}
