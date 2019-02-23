package com.hcl.dmu.demand.vo;

public class SkillVo {

	private long id;
	private String primarySkill;
	private String secondarySkill;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPrimarySkill() {
		return primarySkill;
	}

	public void setPrimarySkill(String primarySkill) {
		this.primarySkill = primarySkill;
	}

	public String getSecondarySkill() {
		return secondarySkill;
	}

	public void setSecondarySkill(String secondarySkill) {
		this.secondarySkill = secondarySkill;
	}

	@Override
	public String toString() {
		return "SkillVo [id=" + id + ", primarySkill=" + primarySkill + ", secondarySkill=" + secondarySkill + "]";
	}

}
