package com.hcl.dmu.clientprocess.service;

import java.util.List;

import javax.transaction.Transactional;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dmu.clientprocess.dao.ClientProcessDetailsDao;
import com.hcl.dmu.clientprocess.entity.CandidateClientProcessEntity;
import com.hcl.dmu.clientprocess.vo.CandidateClientProcessSearchVO;
import com.hcl.dmu.clientprocess.vo.CandidateClientProcessVo;
import com.hcl.dmu.reg.dao.CandaidateDetDAO;

@Service
@Transactional
public class ClientProcessDetailsServiceImpl implements ClientProcessDetailsService {
	
	
	private static final Logger log = LoggerFactory.getLogger(ClientProcessDetailsServiceImpl.class);


	@Autowired
	private ClientProcessDetailsDao clientProcessDetailsDao;
	
	@Autowired
	private CandaidateDetDAO candaidateDetDAO;
	
	@Autowired
	private Mapper mapper;
	
	@Override
	public List<CandidateClientProcessVo> getAllClientProcessDetails(long pagenum) {
		List<CandidateClientProcessVo> candidateDetList = null;
		candidateDetList = clientProcessDetailsDao.getAllClientProcessDetails(pagenum);
		return candidateDetList;
	}

	@Override
	public int insertClientProcessDetails(List<Long> ids) {
		int changeCandidateStatus = 0;
		try {

			int insertClientProcessDetails = clientProcessDetailsDao.insertClientProcessDetails(ids);
			if (insertClientProcessDetails > 0) {
				changeCandidateStatus = candaidateDetDAO.changeCandidateStatus(ids);
			}

		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info(String.valueOf(changeCandidateStatus));
		return changeCandidateStatus;
	}
	
	public List<CandidateClientProcessVo> searchClientProcessDetails(CandidateClientProcessSearchVO searchVO) {
		List<CandidateClientProcessVo> candidateDetList = null;
		
		candidateDetList = clientProcessDetailsDao.searchClientProcessDetails(searchVO);
		return candidateDetList;
	}

	@Override
	public CandidateClientProcessVo getClientProcessDetailsByID(Long clientProcessID) {
		CandidateClientProcessVo candidateClientProcessVo = null;
		try {

			candidateClientProcessVo = new CandidateClientProcessVo();
			CandidateClientProcessEntity findById = clientProcessDetailsDao.findById(clientProcessID);
			mapper.map(findById, candidateClientProcessVo);

		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}

		return candidateClientProcessVo;
	}

	@Override
	public int updateClientProcessDetails(CandidateClientProcessVo candidateClientProcessVo) {
		int updateClientProcessDetails = 0;
		try {
			updateClientProcessDetails = clientProcessDetailsDao.updateClientProcessDetails(candidateClientProcessVo);
			
		} catch (Exception e) {
			
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return updateClientProcessDetails;
	}
	
	
	
	
	
	
	

}
