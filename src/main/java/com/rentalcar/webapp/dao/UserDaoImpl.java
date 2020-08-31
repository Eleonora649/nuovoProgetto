package com.rentalcar.webapp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.query.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.rentalcar.webapp.entities.UserEntity;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, UserEntity> implements UserDao
{
	@Override
	public void saveUser(UserEntity user) 
	{
		persist(user);
	}

	@Override
	public UserEntity update(UserEntity user) 
	{
		return update(user);
	}

	@Override
	public void deleteUser(int id) 
	{
		Query query = getSession().createSQLQuery("delete from User where id_user=:id");
		query.setInteger("id", id);
		query.executeUpdate();
	}

	@Override
	public UserEntity findUserById(int id) 
	{
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("id", id));
		return (UserEntity) criteria.uniqueResult();
	}

	@Override
	public List<UserEntity> findAllUsers() 
	{
		Criteria criteria = createEntityCriteria();
		return (List<UserEntity>) criteria.list();
	}

	public UserEntity findById(int id) 
	{
        return getByKey(id);
    }

	@Override
	public UserEntity findByEmail(String email) 
	{
		UserEntity user = null;
		user = (UserEntity) getSession().createQuery("SELECT email FROM User WHERE email=:email").setParameter("email", email).uniqueResult();//.getSingleResult();
		
		if(user!=null) 
		{
			Hibernate.initialize(user.getRoles());
		}
		return user;	
	}
}
