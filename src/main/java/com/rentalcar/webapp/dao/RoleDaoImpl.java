package com.rentalcar.webapp.dao;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.rentalcar.webapp.entities.Role;

@Repository("roleDao")
public class RoleDaoImpl extends AbstractDao<Integer, Role> implements RoleDao 
{

	@Override
	public Role findByIdRole(int id) {
		Query query = getSession().createQuery("from Role where id_role = :id");
		query.setParameter("id", id);
		return (Role) query.getSingleResult();
	}

}
