package com.tcf.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tcf.basebean.Entity;

/**
 * Personnel entity. @author MyEclipse Persistence Tools
 */
@JsonIgnoreProperties(value={"managers","rulerecordsForPid","rulerecordsForSubmitter"})
public class Personnel implements java.io.Serializable,Entity {

	// Fields

	private Integer id;
	private Title title;
	private Clazz clazz;
	private String account;
	private String password;
	private String name;
	private Integer integral;
	private Boolean isDelete;
	private String remark;
	private Set managers = new HashSet(0);
	private Set rulerecordsForPid = new HashSet(0);
	private Set rulerecordsForSubmitter = new HashSet(0);

	// Constructors

	/** default constructor */
	public Personnel() {
	}

	/** full constructor */
	public Personnel(Title title, Clazz clazz, String account, String password,
			String name, Integer integral, Boolean isDelete, String remark,
			Set managers, Set rulerecordsForPid, Set rulerecordsForSubmitter) {
		this.title = title;
		this.clazz = clazz;
		this.account = account;
		this.password = password;
		this.name = name;
		this.integral = integral;
		this.isDelete = isDelete;
		this.remark = remark;
		this.managers = managers;
		this.rulerecordsForPid = rulerecordsForPid;
		this.rulerecordsForSubmitter = rulerecordsForSubmitter;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Title getTitle() {
		return this.title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public Clazz getClazz() {
		return this.clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getIntegral() {
		return this.integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set getManagers() {
		return this.managers;
	}

	public void setManagers(Set managers) {
		this.managers = managers;
	}

	public Set getRulerecordsForPid() {
		return this.rulerecordsForPid;
	}

	public void setRulerecordsForPid(Set rulerecordsForPid) {
		this.rulerecordsForPid = rulerecordsForPid;
	}

	public Set getRulerecordsForSubmitter() {
		return this.rulerecordsForSubmitter;
	}

	public void setRulerecordsForSubmitter(Set rulerecordsForSubmitter) {
		this.rulerecordsForSubmitter = rulerecordsForSubmitter;
	}

}