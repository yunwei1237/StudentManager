package com.tcf.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.tcf.basebean.Entity;
import com.tcf.dao.Dao;

@Repository
public class DaoImpl extends HibernateTemplate implements Dao {

	@Autowired
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		// TODO Auto-generated method stub
		super.setSessionFactory(sessionFactory);
	}
	public int getRows(Object entity) {
		// TODO Auto-generated method stub
		return super.findByExample(entity).size();
	}

	public int getPages(Object entity,int pageSize) {
		// TODO Auto-generated method stub
		int rows = getRows(entity);
		return rows%pageSize==0?rows/pageSize:rows/pageSize+1;
	}

	public Object get(Class clazz, Serializable id) {
		// TODO Auto-generated method stub
		return super.get(clazz.getName(), id);
	}
	public List find(Object entity, int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return super.findByExample(entity,(pageIndex-1)*pageSize,pageSize);
	}

	public Serializable save(Object entity) {
		// TODO Auto-generated method stub
		return super.save(entity);
	}

	public void update(Object entity) {
		// TODO Auto-generated method stub
		super.update(entity);
	}

	public void delete(Object entity) {
		// TODO Auto-generated method stub
		Entity e = (Entity) entity;
		e.setIsDelete(true);
		super.update(e);
	}
	public List find(Object entity) {
		// TODO Auto-generated method stub
		return super.findByExample(entity);
	}
	
	@Override
	public List find(String queryString) throws DataAccessException {
		// TODO Auto-generated method stub
		return super.find(queryString);
	}
	@Override
	public List find(String queryString, Object value)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return super.find(queryString, value);
	}
	public List find(DetachedCriteria dc, int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return super.findByCriteria(dc, (pageIndex-1)*pageSize, pageSize);
	}
	public List find(DetachedCriteria dc) {
		// TODO Auto-generated method stub
		return super.findByCriteria(dc);
	}
	public List find(String hql, int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return super.getSession().createQuery(hql).
				setFirstResult((pageIndex-1)*pageSize).setMaxResults(pageSize).list();
	}
	public List find(String hql, Object entity, int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return super.getSession().createQuery(hql).setProperties(entity).
				setFirstResult((pageIndex-1)*pageSize).setMaxResults(pageSize).list();
	}

}
