package com.rentalcar.webapp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.rentalcar.webapp.entities.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao
{

	@Override
	public void saveUser(User user) 
	{
		persist(user);
	}

	@Override
	public void update(User user) 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteUser(int id) 
	{
		Query query = getSession().createSQLQuery("delete from User where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
	}

	@Override
	public User findUserById(int id) 
	{
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("id", id));
		return (User) criteria.uniqueResult();
	}

	@Override
	public List<User> findAllUsers() 
	{
		Criteria criteria = createEntityCriteria();
		return (List<User>) criteria.list();
	}

	public User findById(int id) {
        return getByKey(id);
    }

}
