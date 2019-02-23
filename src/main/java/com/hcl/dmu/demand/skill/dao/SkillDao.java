package com.hcl.dmu.demand.skill.dao;

import java.util.List;

import com.hcl.dmu.demand.entity.SkillsEntity;
import com.hcl.dmu.demand.vo.DemandTrakerVo;
import com.hcl.dmu.demand.vo.PrimarySkillVo;
import com.hcl.dmu.demand.vo.SecondarySkillVo;
import com.hcl.dmu.demand.vo.SkillVo;

public interface SkillDao {

	public List<SkillVo> getAllSkillDetails();
	public List<DemandTrakerVo> getSkillDemandDetails();
	
	public SkillsEntity findById(Long id);
	List<PrimarySkillVo> getPrimarySkills();
	public List<SecondarySkillVo> getSecondarySkills(String skillName);
}
