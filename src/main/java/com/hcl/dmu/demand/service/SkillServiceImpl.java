package com.hcl.dmu.demand.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dmu.demand.skill.dao.SkillDao;
import com.hcl.dmu.demand.vo.PrimarySkillVo;
import com.hcl.dmu.demand.vo.SecondarySkillVo;

@Service
@Transactional
public class SkillServiceImpl implements SkillService {

	@Autowired
	private SkillDao skillDao;
	
	@Override
	public List<PrimarySkillVo> getPrimarySkills() {
		return skillDao.getPrimarySkills();
	}

	@Override
	public List<SecondarySkillVo> getSecondarySkills(String skillName) {
		return skillDao.getSecondarySkills(skillName);
	}

}
