package com.rentalcar.webapp.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public boolean authenticate(String email, String password) 
	{
		boolean check = userDao.checkLogin(email, password);

		return check;
	}
	
}
