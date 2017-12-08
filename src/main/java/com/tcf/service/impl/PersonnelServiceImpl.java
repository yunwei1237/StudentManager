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
import com.tcf.entity.Personnel;
import com.tcf.entity.Title;
import com.tcf.service.PersonnelService;
@SuppressWarnings("unchecked")
@Service
public class PersonnelServiceImpl implements PersonnelService {
	//dao
	@Autowired
	private Dao dao;
	
	public Info addBean(Personnel bean) {
		// TODO Auto-generated method stub
		bean.setIsDelete(false);//默认信息未删除
		bean.setIntegral(0);//默认积分为0
		bean.setTitle((Title)dao.get(Title.class, 7));//默认为最低级别
		dao.save(bean);
		return new Info("添加人员成功", null);
	}

	public Info delBean(Serializable id) {
		// TODO Auto-generated method stub
		Personnel bean = (Personnel) dao.get(Personnel.class, id);
		dao.delete(bean);
		return new Info("删除人员成功", null);
	}
	public Info getAllBeans() {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("beans", dao.find(new Personnel()));
		return new Info("添加人员成功", null);
	}

	public Info getBean(Serializable id) {
		// TODO Auto-generated method stub
		Personnel beanInfo = (Personnel) dao.get(Personnel.class, id);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("bean", beanInfo);//人员信息
		map.put("clazzs", dao.find(new Title()));
		return new Info("查询人员成功", null,map);
	}

	public Info updateBean(Personnel bean) {
		// TODO Auto-generated method stub
		Personnel p = (Personnel) dao.get(Personnel.class, bean.getId());
		p.setName(bean.getName());//更改名称
		p.setClazz(bean.getClazz());//更改班级
		p.setRemark(bean.getRemark());//更改备注
		dao.update(p);
		return new Info("更新人员成功", null);
	}
	public Info search(Map<String,Object> models) {
		//条件组合
		DetachedCriteria dc = DetachedCriteria.forClass(Personnel.class);
		dc.createAlias("clazz", "clz");
		Conjunction con = Restrictions.conjunction();
		//按年级名称模糊查询
		if(bean.getName() != null){
			con.add(Restrictions.like("name", bean.getName(),MatchMode.ANYWHERE));
		}
		if(bean.getName() != null){
			con.add(Restrictions.like("account", bean.getAccount(),MatchMode.ANYWHERE));
		}
		if(bean.getClazz() != null && bean.getClazz().getId() != null){
			con.add(Restrictions.eq("clz.id", bean.getClazz().getId()));
		}
		if(bean.getClazz() != null && bean.getClazz().getGrade() != null && bean.getClazz().getGrade().getId() != null){
			con.add(Restrictions.eq("clz.grade.id", bean.getClazz().getGrade().getId()));
		}
		if(bean.getTitle()!= null && bean.getTitle().getId() != null){
			con.add(Restrictions.eq("title.id", bean.getTitle().getId()));
		}
		
		String integralRange = (String) models.get("integralRange");
		if(integralRange != null){
			String[] items = integralRange.split("-");
			String strLow = items[0];
			String strUp = items[1];
			if(strLow != null && !"".equals(strLow.trim())){
				int low = Integer.parseInt(strLow);
				con.add(Restrictions.ge("integral", low));
			}
			if(strUp != null && !"".equals(strUp.trim())){
				int up = Integer.parseInt(strUp);
				con.add(Restrictions.le("integral", up));
			}
		}
		dc.add(con);
		//结果计算与查询
		Integer rows = dao.find(dc).size();//总行数
		Integer pages = rows%pageSize==0?rows/pageSize:rows/pageSize+1;//总页数
		List<Personnel> persons = dao.find(dc,pageIndex,pageSize);//查询的人员集合
		List<Grade> grades = dao.find(new Grade());//全部年级
		Integer gradeId = bean.getClazz() != null && bean.getClazz().getGrade() != null?bean.getClazz().getGrade().getId():null;
		Integer clazzId =  bean.getClazz() != null?bean.getClazz().getId():null;
		Integer titleId = bean.getTitle() != null?bean.getTitle().getId():null;
		List<Title> titles = dao.find(new Title());
		//结果整理
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("pages", pages);//存储总页数
		map.put("pageIndex", pageIndex);//存储当前页码
		map.put("persons", persons);//存储查询的数据
		map.put("gradeId", gradeId);//存储查询的数据
		map.put("clazzId",clazzId);//存储查询的数据
		map.put("grades", grades);//存储查询的数据
		map.put("titleId", titleId);//存储查询的数据
		map.put("titles", titles);//存储查询的数据
		return new Info("查询人员成功", null,map);
	}

	public boolean checkAccount(String account) {
		// TODO Auto-generated method stub
		List<Personnel> list = dao.find(new Personnel(null, null, account, null, null, null, null, null, null, null, null));
		return list.size()==0;
	}
	@Transfuse
	private Personnel bean;
	@Transfuse
	private Integer pageIndex;
	@Transfuse
	private Integer pageSize;
}
