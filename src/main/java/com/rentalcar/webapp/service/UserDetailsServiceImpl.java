package com.rentalcar.webapp.service;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rentalcar.webapp.dao.UserDao;
import com.rentalcar.webapp.dao.UserDetailsDao;
import com.rentalcar.webapp.entities.UserEntity;

@Service("userDetailsServiceImpl")
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService
{
	@Autowired
	private UserDetailsDao userDetailsDao;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException 
	{
		UserEntity user = userDetailsDao.findUserByEmail(email);
		UserBuilder builder = null;
		
		if(user!=null)
		{
			builder = User.withUsername(email);
			builder.password(user.getPassword());
		}
		
		return builder.build();
	
	}

}
