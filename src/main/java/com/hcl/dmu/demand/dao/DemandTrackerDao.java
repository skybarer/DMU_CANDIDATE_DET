package com.hcl.dmu.demand.dao;

import java.util.List;

import com.hcl.dmu.demand.entity.DemandDetailsEntity;
import com.hcl.dmu.demand.vo.DemandDetailsVo;

public interface DemandTrackerDao {
	
	public String insertDemandTracker(DemandDetailsVo demandDetailsVo);
	
	public String updateDemandTrackerDetails(DemandDetailsVo demandDetailsVo);
	
	public DemandDetailsEntity findById(long id);
	
	public List<DemandDetailsVo> getAllDemandTrackerEntities();
	
	public List<DemandDetailsVo> searchDemandTrackerEntities(String skillName, String streamName,String subStreamName);
	
}
