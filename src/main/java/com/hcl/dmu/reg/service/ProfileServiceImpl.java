package com.hcl.dmu.reg.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hcl.dmu.reg.dao.ProfileDao;
import com.hcl.dmu.reg.entity.CandidateDetEntity;

@Service
@Transactional
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileDao profileDao;

	@Override
	public String uploadProfile(CandidateDetEntity candidateDetEntity, MultipartFile file) {
		return profileDao.modifyProfile(candidateDetEntity,file);
	}
	

}
