package com.hcl.dmu.reg.dao;

import org.springframework.web.multipart.MultipartFile;

import com.hcl.dmu.reg.entity.CandidateDetEntity;

public interface ProfileDao {
	
	public String modifyProfile(CandidateDetEntity candidateDetEntity, MultipartFile file);
}
