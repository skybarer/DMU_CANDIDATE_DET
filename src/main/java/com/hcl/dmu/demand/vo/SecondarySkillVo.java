package com.hcl.dmu.demand.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SecondarySkillVo {
	
	private long id;
	private String secondarySkillName;
	@JsonIgnore
	private PrimarySkillVo primarySkillVo;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSecondarySkillName() {
		return secondarySkillName;
	}
	public void setSecondarySkillName(String secondarySkillName) {
		this.secondarySkillName = secondarySkillName;
	}
	public PrimarySkillVo getPrimarySkillVo() {
		return primarySkillVo;
	}
	public void setPrimarySkillVo(PrimarySkillVo primarySkillVo) {
		this.primarySkillVo = primarySkillVo;
	}
	@Override
	public String toString() {
		return "SecondarySkillVo [id=" + id + ", secondarySkillName=" + secondarySkillName + ", primarySkillVo="
				+ primarySkillVo + "]";
	}
	
}
