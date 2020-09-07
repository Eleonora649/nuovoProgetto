package com.rentalcar.webapp.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;

import com.rentalcar.webapp.dao.UserDao;
import com.rentalcar.webapp.entities.UserEntity;

@Service("userDetailsService")
@Transactional
public class UserDetailsServiceImp implements UserDetailsService
{
    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImp.class);
    
	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException 
	{
		UserEntity user = userDao.checkLogin(email);
		UserBuilder builder = null;
		
		if(user!=null)
		{
			builder = User.withUsername(email);
			builder.password(user.getPassword());
			String[] roles = user.getRoles()
			          .stream().map(r -> r.getNameRole()).toArray(String[]::new);

			builder.authorities(roles);
	    } else 
	    {
		    throw new UsernameNotFoundException("User not found.");
		}
		    return builder.build();
	}

}
