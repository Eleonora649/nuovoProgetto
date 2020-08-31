package com.rentalcar.webapp.service;

import java.util.List;

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
	public void addRole(Role role) 
	{
		roleDao.addRole(role);
	}

	@Override
	public List<Role> list() {
	    return roleDao.list();
	}

	@Override
	public Role findByNameRole(String nameRole) 
	{
		return roleDao.findByNameRole(nameRole);
	}

	@Override
	public Role findByIdRole(int idRole) 
	{
		return roleDao.findByIdRole(idRole);
	}
}
