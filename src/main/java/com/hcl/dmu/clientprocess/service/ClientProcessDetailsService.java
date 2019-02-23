package com.hcl.dmu.clientprocess.service;

import java.util.List;

import com.hcl.dmu.clientprocess.vo.CandidateClientProcessSearchVO;
import com.hcl.dmu.clientprocess.vo.CandidateClientProcessVo;

public interface ClientProcessDetailsService {

	public List<CandidateClientProcessVo> getAllClientProcessDetails(long pagenum);

	public int insertClientProcessDetails(List<Long> ids);
	
	public List<CandidateClientProcessVo> searchClientProcessDetails(CandidateClientProcessSearchVO searchVO);
	
	public CandidateClientProcessVo getClientProcessDetailsByID(Long clientProcessID);
	
	public int updateClientProcessDetails(CandidateClientProcessVo candidateClientProcessVo);
	
}
