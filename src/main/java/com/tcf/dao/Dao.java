package com.tcf.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface Dao {
	Serializable save(Object entity);
	void update(Object entity);
	void delete(Object entity);
	Object get(Class clazz,Serializable id);
	List find(String hql);
	List find(String hql,int pageIndex, int pageSize);
	List find(String hql,Object entity);
	List find(String hql,Object entity,int pageIndex,int pageSize);
	List find(Object entity);
	List find(Object entity,int pageIndex,int pageSize);
	List find(DetachedCriteria dc);
	List find(DetachedCriteria dc,int pageIndex,int pageSize);
	int getRows(Object entity);
	int getPages(Object entity,int pageSize);
}
