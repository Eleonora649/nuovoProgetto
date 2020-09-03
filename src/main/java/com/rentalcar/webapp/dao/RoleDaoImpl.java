package com.rentalcar.webapp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.rentalcar.webapp.entities.Role;

@Repository("roleDao")
public class RoleDaoImpl extends AbstractDao<Integer, Role> implements RoleDao 
{
	@Override
	public void addRole(Role role) 
	{
		persist(role);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> list() 
	{
		Criteria criteria = createEntityCriteria();
		return (List<Role>) criteria.list();
//		return sessionFactory.getSession().createQuery("from Role").list();
	}

	@Override
	public Role findByNameRole(String nameRole) 
	{
		Query query = getSession().createQuery("FROM Role WHERE name_role = :nameRole");
		query.setParameter("nameRole", nameRole);
		return (Role) query.getSingleResult();
	}

	@Override
	public Role findByIdRole(int id) {
		Query query = getSession().createQuery("FROM Role WHERE id_role = :id");
		query.setParameter("id", id);
		return (Role) query.getSingleResult();
	}

}
