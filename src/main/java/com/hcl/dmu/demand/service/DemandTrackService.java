package com.hcl.dmu.demand.service;

import java.util.List;

import com.hcl.dmu.demand.vo.DemandDetailsVo;
import com.hcl.dmu.demand.vo.SkillStreamDetails;

public interface DemandTrackService {
	
	public SkillStreamDetails getSkillDemandDetails();
	
	public String insertDemandTrackerService(DemandDetailsVo demandDetailsVo);
	
	public String updateDemandTrackerDetails(DemandDetailsVo demandDetailsVo);
	
	public List<DemandDetailsVo> getAllDemandTrackerEntities();
	
	public List<DemandDetailsVo> searchDemandTrackerEntities(String skillName, String streamName, String subStreamName);


}
