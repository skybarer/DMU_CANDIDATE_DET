package com.hcl.dmu.demand.service;

import java.util.List;

import com.hcl.dmu.demand.vo.PrimarySkillVo;
import com.hcl.dmu.demand.vo.SecondarySkillVo;

public interface SkillService {

	List<PrimarySkillVo> getPrimarySkills();

	List<SecondarySkillVo> getSecondarySkills(String skillName);
}
