package com.tcf.entity;

/**
 * Titlemission entity. @author MyEclipse Persistence Tools
 */

public class Titlemission implements java.io.Serializable {

	// Fields

	private Integer id;
	private Title title;
	private Mission mission;
	private Boolean isDelete;
	private String remark;

	// Constructors

	/** default constructor */
	public Titlemission() {
	}

	/** full constructor */
	public Titlemission(Title title, Mission mission, Boolean isDelete,
			String remark) {
		this.title = title;
		this.mission = mission;
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

	public Title getTitle() {
		return this.title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public Mission getMission() {
		return this.mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
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