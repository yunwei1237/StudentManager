package com.tcf.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.tcf.entity.Grade;
import com.tcf.entity.view.GradeView;
import com.tcf.service.GradeService;
import com.tcf.service.impl.GradeServiceImpl;

public class Test {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper(); //转换器 
		/*Grade grade = new Grade("aaa", true, "aaa",null);
		String json = mapper.writeValueAsString(grade);
		Map map = mapper.readValue(json, Map.class);
		map.put("aaa", "aaaa");
		System.out.println(map);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Grade g = mapper.readValue(mapper.writeValueAsString(map), Grade.class);
		System.out.println(g);*/
		/*ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		GradeService gs = (GradeService) app.getBean("gradeServiceImpl");
		Grade grade = gs.getGrade(2);
		ObjectWriter writer = mapper.writerWithView(GradeView.simple.class);
		String json = writer.writeValueAsString(grade);
		System.out.println(json);*/
	}

}
