/**
 * 
 */
package com.hcl.dmu.reg.service;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.transaction.Transactional;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hcl.dmu.reg.dao.CandaidateDetDAO;
import com.hcl.dmu.reg.entity.CandidateDetEntity;
import com.hcl.dmu.reg.vo.CandidateDet;
import com.hcl.dmu.reg.vo.ProfileSummaryVo;
import com.hcl.dmu.utils.ProfileUtils;

/**
 * @author sekhar.k
 *
 */
@Service
@Transactional
public class CandaidateDetServiceImpl implements CandaidateDetService {

	private static final Logger log = LoggerFactory.getLogger(CandaidateDetServiceImpl.class);

	@Autowired
	private CandaidateDetDAO candaidateDetDAO;

	@Autowired
	private Mapper mapper;

	@Autowired
	private ProfileUtils profileUtils;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public String insertCandidateDetails(CandidateDet candidateDet, MultipartFile file) throws Exception {
		String response = candaidateDetDAO.insertCandidateDetails(candidateDet, file);
		return response;
	}

	@Override
	public List<CandidateDet> getAllCandidateDetails(long pagenum) {
		List<CandidateDet> candidateDetList = null;
		candidateDetList = candaidateDetDAO.getCandidateDetails(pagenum);
		return candidateDetList;
	}

	@Override
	public String modifyCandidateDetails(CandidateDet candidateDet, MultipartFile file) throws Exception {

		String response = candaidateDetDAO.modifyCandidateDetails(candidateDet, file);
		return response;
	}

	@Override
	public CandidateDetEntity findByCandidate(Long id) {
		return candaidateDetDAO.findById(id);
	}

	@Override
	public int initiateHackerRank(List<Long> ids) {
		return candaidateDetDAO.initiateHackerRank(ids);
	}

	@Override
	public String insertProfileSummaryDetails(ProfileSummaryVo profileSummaryVo,MultipartFile photo) {
		String response = candaidateDetDAO.insertProfileSummaryDetails(profileSummaryVo,photo);
		return response;
	}

	@Override
	public ProfileSummaryVo getProfileDetails(Long
			id) {
		return candaidateDetDAO.getProfileDetails(id);
	}

	@Override
	public Long getCandidateDetailsCount() {
		return candaidateDetDAO.getCandidateDetailsCount();
	}

}
