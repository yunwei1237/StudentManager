package com.tcf.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */

public class Role implements java.io.Serializable {

	// Fields

	private Integer id;
	private String roleName;
	private Boolean isDelete;
	private String remark;
	private Set managers = new HashSet(0);
	private Set rolepowers = new HashSet(0);

	// Constructors

	/** default constructor */
	public Role() {
	}

	/** full constructor */
	public Role(String roleName, Boolean isDelete, String remark, Set managers,
			Set rolepowers) {
		this.roleName = roleName;
		this.isDelete = isDelete;
		this.remark = remark;
		this.managers = managers;
		this.rolepowers = rolepowers;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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

	public Set getRolepowers() {
		return this.rolepowers;
	}

	public void setRolepowers(Set rolepowers) {
		this.rolepowers = rolepowers;
	}

}