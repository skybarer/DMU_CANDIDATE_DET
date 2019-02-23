package com.hcl.dmu.reg.service;

import org.springframework.web.multipart.MultipartFile;

import com.hcl.dmu.reg.entity.CandidateDetEntity;

public interface ProfileService {

	public String uploadProfile(CandidateDetEntity candidateDetEntity, MultipartFile file);

}
