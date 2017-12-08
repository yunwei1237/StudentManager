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
import com.tcf.entity.Grade;
import com.tcf.service.GradeService;

@SuppressWarnings("unchecked")
@Service
public class GradeServiceImpl implements GradeService {
	@Autowired
	private Dao dao;
	
	public Info addBean(Grade grade) {
		// TODO Auto-generated method stub
		grade.setIsDelete(false);
		dao.save(grade);
		return new Info("新增年级成功",null);
	}

	public Info delBean(Serializable id) {
		// TODO Auto-generated method stub
		dao.delete(dao.get(Grade.class, id));
		return new Info("删除年级成功", null);
	}

	public Info getAllBeans() {
		// TODO Auto-generated method stub
		//查询没有删除标记为false的年级（没有删除）
		Map<String,Object> objs = new HashMap<String, Object>();
		objs.put("grades", dao.find(new Grade()));
		return new Info("查询班级成功",null,objs) ;
	}

	public Info getBean(Serializable id) {
		// TODO Auto-generated method stub
		Map<String,Object> objs = new HashMap<String, Object>();
		objs.put("grade", dao.get(Grade.class, id));//全部年级
		return new Info("查询班级成功",null,objs) ;
	}

	public Info updateBean(Grade grade) {
		// TODO Auto-generated method stub
		dao.update(grade);
		return new Info("更新班级成功",null) ;
	}

	public Info search(Map<String,Object> map) {
		// TODO Auto-generated method stub
		DetachedCriteria dc = DetachedCriteria.forClass(Grade.class);
		Conjunction con = Restrictions.conjunction();
		//按年级名称模糊查询
		if(bean.getGradeName() != null){
			con.add(Restrictions.like("gradeName", bean.getGradeName(),MatchMode.ANYWHERE));
		}
		dc.add(con);
		int rows = dao.find(dc).size();//行数
		int pages = rows%pageSize==0?rows/pageSize:rows/pageSize+1;//页码
		List<Grade> grades = dao.find(dc,pageIndex,pageSize);//年级的集合
		
		Map<String,Object> objs = new HashMap<String, Object>();
		objs.put("rows", rows);
		objs.put("pages", pages);
		objs.put("grades", grades);
		map.put("pageIndex", pageIndex);//存储当前页码
		return new Info("查询班级成功", null, objs);
	}
	@Transfuse
	private Grade bean;
	@Transfuse
	private Integer pageIndex;
	@Transfuse
	private Integer pageSize;
}
