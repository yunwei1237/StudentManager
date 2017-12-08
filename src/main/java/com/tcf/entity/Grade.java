package com.tcf.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import com.tcf.entity.view.GradeView;

/**
 * Grade entity. @author MyEclipse Persistence Tools
 */
@JsonIgnoreProperties(value={"clazzs"})
public class Grade implements java.io.Serializable {

	
	// Fields
	@JsonView(GradeView.simple.class)
	private Integer id;
	@JsonView(GradeView.simple.class)
	private String gradeName;
	@JsonView(GradeView.simple.class)
	private Boolean isDelete;
	@JsonView(GradeView.simple.class)
	private String remark;
	@JsonView(GradeView.complex.class)
	private Set clazzs = new HashSet(0);

	// Constructors

	/** default constructor */
	public Grade() {
	}

	/** full constructor */
	public Grade(String gradeName, Boolean isDelete, String remark, Set clazzs) {
		this.gradeName = gradeName;
		this.isDelete = isDelete;
		this.remark = remark;
		this.clazzs = clazzs;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGradeName() {
		return this.gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
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

	public Set getClazzs() {
		return this.clazzs;
	}

	public void setClazzs(Set clazzs) {
		this.clazzs = clazzs;
	}

}