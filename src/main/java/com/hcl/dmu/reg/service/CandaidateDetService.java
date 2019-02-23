package com.hcl.dmu.reg.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.hcl.dmu.reg.entity.CandidateDetEntity;
import com.hcl.dmu.reg.vo.CandidateDet;
import com.hcl.dmu.reg.vo.ProfileSummaryVo;

public interface CandaidateDetService{
	
	public String insertCandidateDetails(CandidateDet candidateDet, MultipartFile file) throws Exception;
	
	public List<CandidateDet> getAllCandidateDetails(long pagenum);
	
	public String modifyCandidateDetails(CandidateDet candidateDet,MultipartFile file) throws Exception;

	public CandidateDetEntity findByCandidate(Long id);

	public int initiateHackerRank(List<Long> ids);

	public String insertProfileSummaryDetails(ProfileSummaryVo profileSummaryVo, MultipartFile photo);

	public ProfileSummaryVo getProfileDetails(Long id);
	
	public Long getCandidateDetailsCount();
	
}
