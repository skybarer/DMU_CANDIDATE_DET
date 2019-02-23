package com.hcl.dmu.sowpes.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dmu.clientprocess.dao.ClientProcessDetailsDaoImpl;
import com.hcl.dmu.clientprocess.vo.CandidateClientProcessVo;
import com.hcl.dmu.sowpes.dao.CandidateSowPesDao;
import com.hcl.dmu.sowpes.vo.CandidateSowPesVo;

@Service
@Transactional
public class CandidateSowPesServiceImpl implements CandidateSowPesService {

	private static final Logger log = LoggerFactory.getLogger(ClientProcessDetailsDaoImpl.class);

	@Autowired
	private CandidateSowPesDao candidateSowPesDao;

	@Override
	public List<CandidateClientProcessVo> getAllClientSelectedDetails() {
		List<CandidateClientProcessVo> candidateClientProcessVoList = null;
		candidateClientProcessVoList = candidateSowPesDao.getAllClientSelectedDetails();
		return candidateClientProcessVoList;
	}

	@Override
	public int insertSelectedCandidateDetails(List<CandidateSowPesVo> candidateSowPesVoList) {
		int count = 0;
		try {
			count = candidateSowPesDao.insertSelectedCandidateDetails(candidateSowPesVoList);
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int updateSelectedDetails(CandidateSowPesVo candidateSowPesVo) {
		int updateSelectedDetails = 0;
		try {
			updateSelectedDetails = candidateSowPesDao.updateSelectedDetails(candidateSowPesVo);

		} catch (Exception e) {

			log.error(e.getMessage());
			e.printStackTrace();
		}

		return updateSelectedDetails;

	}

	@Override
	public List<CandidateSowPesVo> getCandidateSowPesDetails() {
		List<CandidateSowPesVo> candidateSowPesVoList = null;
		try {
			candidateSowPesVoList = candidateSowPesDao.getCandidateSowPesDetails();
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return candidateSowPesVoList;
	}

	@Override
	public int updateCandidateSowPesDetails(List<CandidateSowPesVo> candidateSowPesVoList) {
		int count = 0;
		try {
			count = candidateSowPesDao.updateCandidateSowPesDetails(candidateSowPesVoList);
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return count;
	}

}
