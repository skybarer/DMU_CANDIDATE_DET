package com.hcl.dmu.demand.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dmu.demand.dao.DemandTrackerDao;
import com.hcl.dmu.demand.skill.dao.SkillDao;
import com.hcl.dmu.demand.vo.DemandDetailsVo;
import com.hcl.dmu.demand.vo.SkillStreamDetails;

@Service
@Transactional
public class DemandTrackServiceImpl implements DemandTrackService {

	private static final Logger log = LoggerFactory.getLogger(DemandTrackServiceImpl.class);

	@Autowired
	private SkillDao skillDao;

	@Autowired
	private DemandTrackerDao demandTrackerDao;

	public SkillStreamDetails getSkillDemandDetails() {
		SkillStreamDetails skillStreamDetails = null;
		try {
			skillStreamDetails = new SkillStreamDetails();
			skillStreamDetails.setSkill(skillDao.getAllSkillDetails());
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}

		return skillStreamDetails;
	}

	@Override
	public String insertDemandTrackerService(DemandDetailsVo demandDetailsVo) {
		
		return demandTrackerDao.insertDemandTracker(demandDetailsVo);
		
	}

	@Override
	public String updateDemandTrackerDetails(DemandDetailsVo demandDetailsVo) {
		return demandTrackerDao.updateDemandTrackerDetails(demandDetailsVo);
	}

	@Override
	public List<DemandDetailsVo> getAllDemandTrackerEntities() {
		return demandTrackerDao.getAllDemandTrackerEntities();
	}

	@Override
	public List<DemandDetailsVo> searchDemandTrackerEntities(String skillName, String streamName ,String subStreamName) {
		// TODO Auto-generated method stub
		return demandTrackerDao.searchDemandTrackerEntities(skillName, streamName ,subStreamName);
	}


	
	
	

}
