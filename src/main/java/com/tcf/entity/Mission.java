package com.tcf.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Mission entity. @author MyEclipse Persistence Tools
 */

public class Mission implements java.io.Serializable {

	// Fields

	private Integer id;
	private String missionName;
	private String details;
	private Boolean isDelete;
	private Set titlemissions = new HashSet(0);

	// Constructors

	/** default constructor */
	public Mission() {
	}

	/** full constructor */
	public Mission(String missionName, String details, Boolean isDelete,
			Set titlemissions) {
		this.missionName = missionName;
		this.details = details;
		this.isDelete = isDelete;
		this.titlemissions = titlemissions;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMissionName() {
		return this.missionName;
	}

	public void setMissionName(String missionName) {
		this.missionName = missionName;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Set getTitlemissions() {
		return this.titlemissions;
	}

	public void setTitlemissions(Set titlemissions) {
		this.titlemissions = titlemissions;
	}

}