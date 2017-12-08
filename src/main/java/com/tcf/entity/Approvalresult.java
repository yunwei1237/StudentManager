package com.tcf.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Approvalresult entity. @author MyEclipse Persistence Tools
 */

public class Approvalresult implements java.io.Serializable {

	// Fields

	private Integer id;
	private String resultName;
	private Boolean isDelete;
	private String remark;
	private Set rulerecords = new HashSet(0);

	// Constructors

	/** default constructor */
	public Approvalresult() {
	}

	/** full constructor */
	public Approvalresult(String resultName, Boolean isDelete, String remark,
			Set rulerecords) {
		this.resultName = resultName;
		this.isDelete = isDelete;
		this.remark = remark;
		this.rulerecords = rulerecords;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getResultName() {
		return this.resultName;
	}

	public void setResultName(String resultName) {
		this.resultName = resultName;
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

	public Set getRulerecords() {
		return this.rulerecords;
	}

	public void setRulerecords(Set rulerecords) {
		this.rulerecords = rulerecords;
	}

}