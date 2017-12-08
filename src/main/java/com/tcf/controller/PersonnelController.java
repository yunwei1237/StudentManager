package com.tcf.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tcf.basebean.Info;
import com.tcf.entity.Personnel;
import com.tcf.service.PersonnelService;

@Controller
@RequestMapping("person")
public class PersonnelController {
	@Autowired
	private PersonnelService ps;
	/*@Autowired
	private PersonnelService ps;*/
	/**
	 * 新增人员
	 * @param person
	 * @return
	 */
	@RequestMapping("addPersonnel.do")
	public @ResponseBody Info addPersonnel(@RequestBody Personnel person){
		return ps.addBean(person);
	}
	/**
	 * 删除人员
	 * @param person
	 * @return
	 */
	@RequestMapping("deletePersonnel.do")
	public @ResponseBody Info deletePersonnel(@RequestBody Personnel person){
		return ps.delBean(person.getId());
	}
	/**
	 * 更新人员
	 * @param person
	 * @return
	 */
	@RequestMapping("updatePersonnel.do")
	public @ResponseBody Info updatePersonnel(@RequestBody Personnel person){
		return ps.updateBean(person);
	}
	/**
	 * 查询单个人员
	 * @param person
	 * @return
	 */
	@RequestMapping("getPersonnel.do")
	public @ResponseBody Info getPersonnel(@RequestBody Personnel person){
		return ps.getBean(person.getId());
	}
	/**
	 * 根据条件查询人员集合
	 * @param map
	 * @return
	 */
	@RequestMapping("searchPersonnels.do")
	public @ResponseBody Info searchPersonnels(@RequestBody Map<String,Object> models){
		return ps.search(models);
	}
	/**
	 * 检测人员名是否存在
	 * @param map
	 * @return
	 */
	@RequestMapping("checkAccount.do")
	public @ResponseBody boolean checkAccount(String account){
		return ps.checkAccount(account);
	}
}