package com.hcl.dmu.demand.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PrimarySkillVo {

	private long id;
	private String primarySkillName;
	@JsonIgnore
	private List<SecondarySkillVo> secondarySkillVos;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPrimarySkillName() {
		return primarySkillName;
	}
	public void setPrimarySkillName(String primarySkillName) {
		this.primarySkillName = primarySkillName;
	}
	public List<SecondarySkillVo> getSecondarySkillVos() {
		return secondarySkillVos;
	}
	public void setSecondarySkillVos(List<SecondarySkillVo> secondarySkillVos) {
		this.secondarySkillVos = secondarySkillVos;
	}
	@Override
	public String toString() {
		return "PrimarySkillVo [id=" + id + ", primarySkillName=" + primarySkillName + ", secondarySkillVos="
				+ secondarySkillVos + "]";
	}
	
	
	
}
