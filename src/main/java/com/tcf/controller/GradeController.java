package com.tcf.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tcf.basebean.Info;
import com.tcf.entity.Grade;
import com.tcf.service.GradeService;

@Controller
@RequestMapping("grade")
public class GradeController {
	@Autowired
	private GradeService gs;
	
	@RequestMapping("addGrade.do")
	public @ResponseBody Info addGrade(@RequestBody Grade grade){
		return gs.addBean(grade);
	}
	@RequestMapping("deleteGrade.do")
	public @ResponseBody Info deleteGrade(@RequestBody Grade grade){
		return gs.delBean(grade.getId());
	}
	@RequestMapping("updateGrade.do")
	public @ResponseBody Info updateGrade(@RequestBody Grade grade){
		return gs.updateBean(grade);
	}
	@RequestMapping("getGrade.do")
	public @ResponseBody Info getGrade(@RequestBody Grade grade){
		return gs.getBean(grade.getId());
	}
	/**
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("searchGrades.do")
	public @ResponseBody Info searchGrades(@RequestBody Map<String, Object> models){
		return gs.search(models);
	}
	@RequestMapping("getAllGrades.do")
	public @ResponseBody Info getAllGrades(@RequestBody Map<String, Object> models){
		return gs.getAllBeans();
	}
}
