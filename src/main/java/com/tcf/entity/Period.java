package com.tcf.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Period entity. @author MyEclipse Persistence Tools
 */

public class Period implements java.io.Serializable {

	// Fields

	private Integer id;
	private String periodName;
	private Boolean isDelete;
	private String remark;
	private Set rules = new HashSet(0);

	// Constructors

	/** default constructor */
	public Period() {
	}

	/** full constructor */
	public Period(String periodName, Boolean isDelete, String remark, Set rules) {
		this.periodName = periodName;
		this.isDelete = isDelete;
		this.remark = remark;
		this.rules = rules;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPeriodName() {
		return this.periodName;
	}

	public void setPeriodName(String periodName) {
		this.periodName = periodName;
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

	public Set getRules() {
		return this.rules;
	}

	public void setRules(Set rules) {
		this.rules = rules;
	}

}