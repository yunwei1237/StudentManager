package com.tcf.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Clazz entity. @author MyEclipse Persistence Tools
 */
@JsonIgnoreProperties(value={"personnels"})
public class Clazz implements java.io.Serializable {

	// Fields

	private Integer id;
	private Grade grade;
	private String clazzName;
	private Boolean isDelete;
	private String remark;
	private Set personnels = new HashSet(0);

	// Constructors

	/** default constructor */
	public Clazz() {
	}

	/** full constructor */
	public Clazz(Grade grade, String clazzName, Boolean isDelete,
			String remark, Set personnels) {
		this.grade = grade;
		this.clazzName = clazzName;
		this.isDelete = isDelete;
		this.remark = remark;
		this.personnels = personnels;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Grade getGrade() {
		return this.grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public String getClazzName() {
		return this.clazzName;
	}

	public void setClazzName(String clazzName) {
		this.clazzName = clazzName;
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

}