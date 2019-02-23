/**
 * 
 */
package com.hcl.dmu.reg.dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.hcl.dmu.reg.entity.CandidateDetEntity;
import com.hcl.dmu.reg.vo.CandidateDet;
import com.hcl.dmu.reg.vo.ProfileSummaryVo;

/**
 * @author sekhar.k
 *
 */
public interface CandaidateDetDAO {
	
	public String insertCandidateDetails(CandidateDet candidateDet, MultipartFile file) throws Exception;
	
	public List<CandidateDet> getCandidateDetails(long pagenum);
	
	public String modifyCandidateDetails(CandidateDet candidateDet,MultipartFile file) throws Exception;

	public CandidateDetEntity findById(Long id);
	
	
	public int changeCandidateStatus(List<Long> ids);

	public int initiateHackerRank(List<Long> ids);

	public String insertProfileSummaryDetails(ProfileSummaryVo profileSummaryVo, MultipartFile photo);

	public ProfileSummaryVo getProfileDetails(Long id);
	
	public Long getCandidateDetailsCount();
}
