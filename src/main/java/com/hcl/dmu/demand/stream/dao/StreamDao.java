package com.hcl.dmu.demand.stream.dao;

import java.util.List;

import com.hcl.dmu.demand.entity.DemandStreamEntity;
import com.hcl.dmu.demand.vo.DemandStreamVo;

public interface StreamDao {
	
	public List<DemandStreamVo> getAllStreamDetails();
	
	DemandStreamEntity findById(Long id);
	
}
