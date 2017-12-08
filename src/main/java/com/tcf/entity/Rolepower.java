package com.tcf.entity;

/**
 * Rolepower entity. @author MyEclipse Persistence Tools
 */

public class Rolepower implements java.io.Serializable {

	// Fields

	private Integer id;
	private Role role;
	private String op;
	private Boolean isDelete;
	private String remark;

	// Constructors

	/** default constructor */
	public Rolepower() {
	}

	/** full constructor */
	public Rolepower(Role role, String op, Boolean isDelete, String remark) {
		this.role = role;
		this.op = op;
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

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getOp() {
		return this.op;
	}

	public void setOp(String op) {
		this.op = op;
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