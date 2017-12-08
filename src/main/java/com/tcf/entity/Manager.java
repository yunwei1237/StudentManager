package com.tcf.entity;

/**
 * Manager entity. @author MyEclipse Persistence Tools
 */

public class Manager implements java.io.Serializable {

	// Fields

	private Integer id;
	private Role role;
	private Rolestatus rolestatus;
	private Personnel personnel;
	private Boolean isDelete;
	private String remark;

	// Constructors

	/** default constructor */
	public Manager() {
	}

	/** full constructor */
	public Manager(Role role, Rolestatus rolestatus, Personnel personnel,
			Boolean isDelete, String remark) {
		this.role = role;
		this.rolestatus = rolestatus;
		this.personnel = personnel;
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

	public Rolestatus getRolestatus() {
		return this.rolestatus;
	}

	public void setRolestatus(Rolestatus rolestatus) {
		this.rolestatus = rolestatus;
	}

	public Personnel getPersonnel() {
		return this.personnel;
	}

	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
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