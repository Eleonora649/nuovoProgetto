package com.rentalcar.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentalcar.webapp.dao.RoleDao;
import com.rentalcar.webapp.entities.Role;

@Service("roleService")
public class RoleServiceImpl implements RoleService
{

	@Autowired
	private RoleDao roleDao;
	
	@Override
	public Role findByIdRole(int idRole) 
	{
		return roleDao.findByIdRole(idRole);
	}

}
