package com.tcf.entity;

import java.sql.Timestamp;

/**
 * Rulerecord entity. @author MyEclipse Persistence Tools
 */

public class Rulerecord implements java.io.Serializable {

	// Fields

	private Integer id;
	private Rule ruleByRid;
	private Personnel personnelBySubmitter;
	private Rule ruleByApprover;
	private Approvalresult approvalresult;
	private Personnel personnelByPid;
	private Integer integral;
	private Timestamp submitTime;
	private Timestamp approvalTime;
	private Boolean isDelete;
	private String remark;

	// Constructors

	/** default constructor */
	public Rulerecord() {
	}

	/** minimal constructor */
	public Rulerecord(Timestamp submitTime, Timestamp approvalTime) {
		this.submitTime = submitTime;
		this.approvalTime = approvalTime;
	}

	/** full constructor */
	public Rulerecord(Rule ruleByRid, Personnel personnelBySubmitter,
			Rule ruleByApprover, Approvalresult approvalresult,
			Personnel personnelByPid, Integer integral, Timestamp submitTime,
			Timestamp approvalTime, Boolean isDelete, String remark) {
		this.ruleByRid = ruleByRid;
		this.personnelBySubmitter = personnelBySubmitter;
		this.ruleByApprover = ruleByApprover;
		this.approvalresult = approvalresult;
		this.personnelByPid = personnelByPid;
		this.integral = integral;
		this.submitTime = submitTime;
		this.approvalTime = approvalTime;
		this.isDelete = isDelete;
		this.remark = remark;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Rule getRuleByRid() {
		return this.ruleByRid;
	}

	public void setRuleByRid(Rule ruleByRid) {
		this.ruleByRid = ruleByRid;
	}

	public Personnel getPersonnelBySubmitter() {
		return this.personnelBySubmitter;
	}

	public void setPersonnelBySubmitter(Personnel personnelBySubmitter) {
		this.personnelBySubmitter = personnelBySubmitter;
	}

	public Rule getRuleByApprover() {
		return this.ruleByApprover;
	}

	public void setRuleByApprover(Rule ruleByApprover) {
		this.ruleByApprover = ruleByApprover;
	}

	public Approvalresult getApprovalresult() {
		return this.approvalresult;
	}

	public void setApprovalresult(Approvalresult approvalresult) {
		this.approvalresult = approvalresult;
	}

	public Personnel getPersonnelByPid() {
		return this.personnelByPid;
	}

	public void setPersonnelByPid(Personnel personnelByPid) {
		this.personnelByPid = personnelByPid;
	}

	public Integer getIntegral() {
		return this.integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public Timestamp getSubmitTime() {
		return this.submitTime;
	}

	public void setSubmitTime(Timestamp submitTime) {
		this.submitTime = submitTime;
	}

	public Timestamp getApprovalTime() {
		return this.approvalTime;
	}

	public void setApprovalTime(Timestamp approvalTime) {
		this.approvalTime = approvalTime;
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

}