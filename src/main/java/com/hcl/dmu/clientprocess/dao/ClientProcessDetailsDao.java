package com.hcl.dmu.clientprocess.dao;

import java.util.List;

import com.hcl.dmu.clientprocess.entity.CandidateClientProcessEntity;
import com.hcl.dmu.clientprocess.vo.CandidateClientProcessSearchVO;
import com.hcl.dmu.clientprocess.vo.CandidateClientProcessVo;

public interface ClientProcessDetailsDao {

	public List<CandidateClientProcessVo> getAllClientProcessDetails(long pagenum);

	public int insertClientProcessDetails(List<Long> ids);
	
	public CandidateClientProcessEntity findById(Long id);
	
	public List<CandidateClientProcessVo> searchClientProcessDetails(CandidateClientProcessSearchVO searchVO);
	
	public int updateClientProcessDetails(CandidateClientProcessVo candidateClientProcessVo);
}
