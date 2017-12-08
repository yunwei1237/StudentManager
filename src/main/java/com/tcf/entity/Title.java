package com.tcf.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.tcf.basebean.Entity;

/**
 * Title entity. @author MyEclipse Persistence Tools
 */
@JsonIgnoreProperties(value={"personnels","titlemissions"})
public class Title implements java.io.Serializable,Entity {

	// Fields

	private Integer id;
	private String titleName;
	private Integer integral;
	private Boolean isDelete;
	private String remark;
	private Set personnels = new HashSet(0);
	private Set titlemissions = new HashSet(0);

	// Constructors

	/** default constructor */
	public Title() {
	}

	/** full constructor */
	public Title(String titleName, Integer integral, Boolean isDelete,
			String remark, Set personnels, Set titlemissions) {
		this.titleName = titleName;
		this.integral = integral;
		this.isDelete = isDelete;
		this.remark = remark;
		this.personnels = personnels;
		this.titlemissions = titlemissions;
	}
	
	// Property accessors

	public Title(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitleName() {
		return this.titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
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

	public Set getPersonnels() {
		return this.personnels;
	}

	public void setPersonnels(Set personnels) {
		this.personnels = personnels;
	}

	public Set getTitlemissions() {
		return this.titlemissions;
	}

	public void setTitlemissions(Set titlemissions) {
		this.titlemissions = titlemissions;
	}

}