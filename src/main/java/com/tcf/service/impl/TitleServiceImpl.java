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
import com.tcf.entity.Personnel;
import com.tcf.entity.Title;
import com.tcf.service.TitleService;

@SuppressWarnings("unchecked")
@Service
public class TitleServiceImpl implements TitleService {
	@Autowired
	private Dao dao;
	
	public Info addBean(Title title) {
		// TODO Auto-generated method stub
		title.setIsDelete(false);
		dao.save(title);
		return new Info("新增头衔成功", null);
	}

	public Info delBean(Serializable id) {
		// TODO Auto-generated method stub
		dao.delete(new Title((Integer) id));
		return new Info("新增头衔成功", null);
	}

	public Info updateBean(Title title) {
		// TODO Auto-generated method stub
		dao.update(title);
		return new Info("删除头衔成功", null);
	}

	public Info getAllBeans() {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("titles", dao.find(new Title()));
		return new Info("成功", null, map);
	}

	
	public Info search(Map<String, Object> map) {
		// TODO Auto-generated method stub
		DetachedCriteria dc = DetachedCriteria.forClass(Personnel.class);
		Conjunction con = Restrictions.conjunction();
		//按年级名称模糊查询
		if(bean.getTitleName() != null){
			con.add(Restrictions.like("titleName", bean.getTitleName(),MatchMode.ANYWHERE));
		}
		//查询没有删除标记
		con.add(Restrictions.eq("isDelete", false));
		dc.add(con);
		
		List<Title> titles = dao.find(dc,pageIndex,pageSize);
		int rows = dao.find(dc).size();
		int pages = rows%pageSize==0?rows/pageSize:rows/pageSize+1;
		
		Map<String,Object> objs = new HashMap<String, Object>();
		objs.put("rows", rows);
		objs.put("pages", pages);
		objs.put("titles", titles);
		return new Info("查询头衔成功", null, objs);
	}

	public Info getBean(Serializable id) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("title", dao.get(Title.class, id));
		return new Info("查询头衔信息成功", null,map);
	}
	@Transfuse
	private Title bean;
	@Transfuse
	private Integer pageIndex;
	@Transfuse
	private Integer pageSize;
}
