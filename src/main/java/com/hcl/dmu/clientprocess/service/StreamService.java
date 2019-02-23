package com.hcl.dmu.clientprocess.service;

import java.util.List;

import com.hcl.dmu.clientprocess.vo.StreamEntityVo;
import com.hcl.dmu.clientprocess.vo.SubStreamEntityVo;

public interface StreamService {
	
	
	 List<StreamEntityVo> getAllStreamDetails();

	List<SubStreamEntityVo> getAllSubStreamDetails(String streamName);
	 

}
