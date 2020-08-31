package com.rentalcar.webapp.service;

import java.util.List;

import com.rentalcar.webapp.entities.Role;

public interface RoleService {

	void addRole(Role role);
	
	List<Role> list();
	
	Role findByIdRole(int idRole);
	
	Role findByNameRole(String nameRole);
}
