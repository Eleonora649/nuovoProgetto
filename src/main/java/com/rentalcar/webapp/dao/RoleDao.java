package com.rentalcar.webapp.dao;

import java.util.List;

import com.rentalcar.webapp.entities.Role;

public interface RoleDao 
{
	void addRole(Role role);

	Role findByIdRole(int idRole);

	Role findByNameRole(String nameRole);

	List<Role> list();
}
