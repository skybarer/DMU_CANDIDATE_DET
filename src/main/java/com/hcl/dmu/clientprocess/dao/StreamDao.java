package com.hcl.dmu.clientprocess.dao;

import java.util.List;

import com.hcl.dmu.clientprocess.vo.StreamEntityVo;
import com.hcl.dmu.clientprocess.vo.SubStreamEntityVo;

public interface StreamDao {

	List<StreamEntityVo> getAllStreamDetails();

	List<SubStreamEntityVo> getAllSubStreamDetails(String streamName);

}
