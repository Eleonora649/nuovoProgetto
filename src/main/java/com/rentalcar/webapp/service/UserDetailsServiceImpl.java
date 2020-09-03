package com.rentalcar.webapp.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rentalcar.webapp.dao.UserDao;
import com.rentalcar.webapp.entities.UserEntity;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService
{
	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException 
	{
		UserEntity user= userDao.findByEmail(email);
		
		Set<GrantedAuthority> grAu = new HashSet<GrantedAuthority>();
		grAu.add(new SimpleGrantedAuthority("customer"));
		grAu.add(new SimpleGrantedAuthority("admin"));
		
		return new User(user.getEmail(), user.getPassword(), grAu);
	}

}
