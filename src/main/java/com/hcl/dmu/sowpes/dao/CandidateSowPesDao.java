package com.hcl.dmu.sowpes.dao;

import java.util.List;

import com.hcl.dmu.clientprocess.vo.CandidateClientProcessVo;
import com.hcl.dmu.sowpes.vo.CandidateSowPesVo;

public interface CandidateSowPesDao {

	List<CandidateClientProcessVo> getAllClientSelectedDetails();
	
	
	public int updateSelectedDetails(CandidateSowPesVo candidateSowPesVo);

	int insertSelectedCandidateDetails(List<CandidateSowPesVo> candidateSowPesVoList);

	List<CandidateSowPesVo> getCandidateSowPesDetails();

	int updateCandidateSowPesDetails(List<CandidateSowPesVo> candidateSowPesVoList);

}
