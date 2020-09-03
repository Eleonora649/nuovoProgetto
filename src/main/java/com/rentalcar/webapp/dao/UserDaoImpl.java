package com.rentalcar.webapp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.query.Query;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.rentalcar.webapp.entities.UserEntity;

@Repository("userDao")
@Transactional
public class UserDaoImpl extends AbstractDao<Integer, UserEntity> implements UserDao
{
	@Override
	public void saveUser(UserEntity user) 
	{
		persist(user);
	}

	@Override
	public void updateUser(UserEntity user) 
	{
		update(user);
	}

	@Override
	public void deleteUser(int id) 
	{
		Query query = getSession().createSQLQuery("delete from user where id_user=:id");
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
		user = (UserEntity) getSession().createQuery("SELECT email FROM user WHERE email=:email").setParameter("email", email).uniqueResult();//.getSingleResult();
		getSession().get(UserEntity.class, email);
		if(user!=null) 
		{
			Hibernate.initialize(user.getRoles());
		}
		return user;	
	}
	
	@Override
	public UserEntity checkLogin(String email)
	{
		UserEntity user = (UserEntity) getSession().createQuery("from UserEntity u where u.email=:email")
							.setParameter("email", email).uniqueResult();
//		getSessSion().get(UserEntity.class, email);
		return user;
	}

}
