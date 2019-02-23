package com.hcl.dmu.sowpes.service;

import java.util.List;

import com.hcl.dmu.clientprocess.vo.CandidateClientProcessVo;
import com.hcl.dmu.sowpes.vo.CandidateSowPesVo;

public interface CandidateSowPesService {

	public List<CandidateClientProcessVo> getAllClientSelectedDetails();
	
	public int insertSelectedCandidateDetails(List<CandidateSowPesVo> candidateSowPesVoList);
	
	public int updateSelectedDetails(CandidateSowPesVo candidateSowPesVo);

	public List<CandidateSowPesVo> getCandidateSowPesDetails();

	public int updateCandidateSowPesDetails(List<CandidateSowPesVo> candidateSowPesVoList);


}
