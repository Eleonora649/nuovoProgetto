package com.rentalcar.webapp.dao;

import java.io.Serializable;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao <PK extends Serializable, T>
{
	private final Class<T> persistentClass;
	
	@SuppressWarnings("unchecked")
    public AbstractDao()
	{
        this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }
	
	@Autowired
    private SessionFactory sessionFactory;
 
    protected Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }
 
    @SuppressWarnings("unchecked")
    public T getByKey(final long id) 
    {
        return (T) getSession().get(persistentClass, id);
    }
 
    public void persist(T entity) 
    {
        getSession().persist(entity);
    }
    
    @SuppressWarnings("unchecked")
    public T update(final T entity) 
    {
    	return (T) getSession().merge(entity);
    }
 
    public void delete(T entity) 
    {
        getSession().delete(entity);
    }
    
    public void deleteById(final long id)
    {
    	final T entity = getByKey(id);
    	delete(entity);
    }
    
	@SuppressWarnings("unchecked")
    public List<T> findAll()
    {
    	return getSession().createQuery("from" + persistentClass.getName()).getResultList();
    }
    
	protected Criteria createEntityCriteria()
	{
        return getSession().createCriteria(persistentClass);
    }
}
