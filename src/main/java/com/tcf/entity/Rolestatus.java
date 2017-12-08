package com.tcf.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Rolestatus entity. @author MyEclipse Persistence Tools
 */

public class Rolestatus implements java.io.Serializable {

	// Fields

	private Integer id;
	private String statusName;
	private Boolean isDelete;
	private String remark;
	private Set managers = new HashSet(0);

	// Constructors

	/** default constructor */
	public Rolestatus() {
	}

	/** full constructor */
	public Rolestatus(String statusName, Boolean isDelete, String remark,
			Set managers) {
		this.statusName = statusName;
		this.isDelete = isDelete;
		this.remark = remark;
		this.managers = managers;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatusName() {
		return this.statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
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

}