package com.hcl.dmu.demand.vo;

import java.util.List;

public class SkillStreamDetails {

	private List<SkillVo> skill;


	public List<SkillVo> getSkill() {
		return skill;
	}

	public void setSkill(List<SkillVo> skill) {
		this.skill = skill;
	}

	@Override
	public String toString() {
		return "SkillStreamDetails [skill=" + skill + "]";
	}

}
