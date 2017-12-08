package com.tcf.basebean;

import java.io.Serializable;
import java.util.Map;

public abstract interface BaseService<T> {
	/**
	 * 增加实体
	 * @param bean
	 * @return
	 */
	public abstract Info addBean(T bean);
	/**
	 * 删除实体
	 * @param id
	 * @return
	 */
	public abstract Info delBean(Serializable id);
	/**
	 * 更新实体
	 * @param bean
	 * @return
	 */
	public abstract Info updateBean(T bean);
	/**
	 * 获得全部实体
	 * @return
	 */
	public abstract Info getAllBeans();
	/**
	 * 根据条件查询实体
	 * @param map
	 * @return
	 */
	public abstract Info search(Map<String,Object> map);
	/**
	 * 根据Id查询单个实体
	 * @param id
	 * @return
	 */
	public abstract Info getBean(Serializable id);
	
}
