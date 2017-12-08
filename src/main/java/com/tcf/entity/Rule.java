package com.tcf.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Rule entity. @author MyEclipse Persistence Tools
 */

public class Rule implements java.io.Serializable {

	// Fields

	private Integer id;
	private Period period;
	private Ruletype ruletype;
	private String details;
	private Integer lowIntegral;
	private Integer highIntegral;
	private Boolean isDelete;
	private String remark;
	private Set rulerecordsForApprover = new HashSet(0);
	private Set rulerecordsForRid = new HashSet(0);

	// Constructors

	/** default constructor */
	public Rule() {
	}

	/** full constructor */
	public Rule(Period period, Ruletype ruletype, String details,
			Integer lowIntegral, Integer highIntegral, Boolean isDelete,
			String remark, Set rulerecordsForApprover, Set rulerecordsForRid) {
		this.period = period;
		this.ruletype = ruletype;
		this.details = details;
		this.lowIntegral = lowIntegral;
		this.highIntegral = highIntegral;
		this.isDelete = isDelete;
		this.remark = remark;
		this.rulerecordsForApprover = rulerecordsForApprover;
		this.rulerecordsForRid = rulerecordsForRid;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Period getPeriod() {
		return this.period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public Ruletype getRuletype() {
		return this.ruletype;
	}

	public void setRuletype(Ruletype ruletype) {
		this.ruletype = ruletype;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Integer getLowIntegral() {
		return this.lowIntegral;
	}

	public void setLowIntegral(Integer lowIntegral) {
		this.lowIntegral = lowIntegral;
	}

	public Integer getHighIntegral() {
		return this.highIntegral;
	}

	public void setHighIntegral(Integer highIntegral) {
		this.highIntegral = highIntegral;
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

	public Set getRulerecordsForApprover() {
		return this.rulerecordsForApprover;
	}

	public void setRulerecordsForApprover(Set rulerecordsForApprover) {
		this.rulerecordsForApprover = rulerecordsForApprover;
	}

	public Set getRulerecordsForRid() {
		return this.rulerecordsForRid;
	}

	public void setRulerecordsForRid(Set rulerecordsForRid) {
		this.rulerecordsForRid = rulerecordsForRid;
	}

}