package com.tcf.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tcf.basebean.Info;
import com.tcf.entity.Clazz;
import com.tcf.service.ClazzService;

@Controller
@RequestMapping("clazz")
public class ClazzController {
	@Autowired
	private ClazzService cs;
	
	@RequestMapping("addClazz.do")
	public @ResponseBody Info addClazz(@RequestBody Clazz clazz){
		return cs.addBean(clazz);
	}
	@RequestMapping("deleteClazz.do")
	public @ResponseBody Info deleteClazz(@RequestBody Clazz clazz){
		return cs.delBean(clazz.getId());
	}
	@RequestMapping("updateClazz.do")
	public @ResponseBody Info updateClazz(@RequestBody Clazz clazz){
		return cs.updateBean(clazz);
	}
	@RequestMapping("getClazz.do")
	public @ResponseBody Info getClazz(@RequestBody Clazz clazz){
		return cs.getBean(clazz.getId());
	}
	@RequestMapping("searchClazzs.do")
	public @ResponseBody Info searchClazzs(@RequestBody Map<String, Object> models){
		return cs.search(models);
	}
	@RequestMapping("getAllClazzs.do")
	public @ResponseBody Info getAllGrades(@RequestBody Map<String, Object> models){
		return cs.getAllBeans();
	}
}
