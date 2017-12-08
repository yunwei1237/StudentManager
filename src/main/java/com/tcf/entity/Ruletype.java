package com.tcf.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Ruletype entity. @author MyEclipse Persistence Tools
 */

public class Ruletype implements java.io.Serializable {

	// Fields

	private Integer id;
	private String typeName;
	private Boolean isDelete;
	private String remark;
	private Set rules = new HashSet(0);

	// Constructors

	/** default constructor */
	public Ruletype() {
	}

	/** full constructor */
	public Ruletype(String typeName, Boolean isDelete, String remark, Set rules) {
		this.typeName = typeName;
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

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
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