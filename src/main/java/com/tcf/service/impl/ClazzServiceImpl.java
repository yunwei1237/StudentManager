package com.tcf.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcf.annotation.Transfuse;
import com.tcf.basebean.Info;
import com.tcf.dao.Dao;
import com.tcf.entity.Clazz;
import com.tcf.entity.Grade;
import com.tcf.service.ClazzService;
@SuppressWarnings("unchecked")
@Service
public class ClazzServiceImpl implements ClazzService {
	@Autowired
	private Dao dao;
	public Info addBean(Clazz clazz) {
		// TODO Auto-generated method stub
		clazz.setIsDelete(false);
		dao.save(clazz);
		return new Info("新增班级成功", null);
	}

	public Info delBean(Serializable id) {
		// TODO Auto-generated method stub
		dao.delete(dao.get(Clazz.class, id));
		return new Info("删除班级成功", null);
	}

	public Info  getAllBeans() {
		// TODO Auto-generated method stub
		Map<String,Object> objs = new HashMap<String, Object>();
		objs.put("clazzs", dao.find(new Clazz()));
		return new Info("查询班级成功",null,objs) ;
	}

	public Info getBean(Serializable id) {
		// TODO Auto-generated method stub
		Map<String,Object> objs = new HashMap<String, Object>();
		objs.put("clazz", dao.get(Clazz.class, id));
		objs.put("grades", dao.find(new Grade()));//全部年级
		return new Info("查询班级成功",null,objs) ;
	}

	public Info updateBean(Clazz clazz) {
		// TODO Auto-generated method stub
		dao.update(clazz);
		return new Info("更新班级成功", null);
	}

	
	public Info search(Map<String,Object> map) {
		// TODO Auto-generated method stub
		DetachedCriteria dc = DetachedCriteria.forClass(Clazz.class);
		Conjunction con = Restrictions.conjunction();
		//按年级名称模糊查询
		if(bean.getClazzName() != null){
			con.add(Restrictions.like("clazzName", bean.getClazzName(),MatchMode.ANYWHERE));
		}
		if(bean.getGrade() != null && bean.getGrade().getId() != null){
			con.add(Restrictions.eq("grade.id", bean.getGrade().getId()));
		}
		dc.add(con);
		
		Map<String,Object> objs = new HashMap<String, Object>();
		List<Clazz> clazzs = null;
		//分页需要的数据
		if(pageIndex != null && pageSize != null){
			int rows = dao.find(dc).size();//行数
			int pages = rows%pageSize==0?rows/pageSize:rows/pageSize+1;//页码
			objs.put("rows", rows);
			objs.put("pages", pages);
			map.put("pageIndex", pageIndex);//存储当前页码
			clazzs = dao.find(dc,pageIndex,pageSize);//班级的集合
		}else{
			clazzs = dao.find(dc);//班级的集合
		}
		//查询需要的数据
		objs.put("clazzs", clazzs);
		return new Info("查询班级成功", null, objs)  ;
	}
	@Transfuse
	private Clazz bean;
	@Transfuse
	private Integer pageIndex;
	@Transfuse
	private Integer pageSize;
}
