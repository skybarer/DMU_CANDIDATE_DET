package com.hcl.dmu.reg.dao;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.hcl.dmu.reg.entity.CandidateDetEntity;
import com.hcl.dmu.reg.entity.ResumeUploadsEntity;
import com.hcl.dmu.reg.vo.CandidateDet;
import com.hcl.dmu.utils.ProfileUtils;

@Repository
public class ProfileDaoImpl extends AbstractDAO implements ProfileDao {

	@Autowired
	private Mapper mapper;

	@Autowired
	private ProfileUtils profileUtils;

	@Value("${uploadProfilePath}")
	private String uploadProfilePath;

	@Override
	public String modifyProfile(CandidateDetEntity candidateDetEntity, MultipartFile file) {
		String result = "";
		CandidateDet candidateDet = new CandidateDet();
		mapper.map(candidateDetEntity, candidateDet);
		String filePath = profileUtils.getUploadedFilePath(candidateDet.getName(), file);
		if (!filePath.isEmpty()) {
			ResumeUploadsEntity resumeUploads = candidateDetEntity.getResumeUploads();
			resumeUploads = resumeUploads!=null?resumeUploads: new ResumeUploadsEntity();
			resumeUploads.setCandidateDetEntity(candidateDetEntity);
			resumeUploads.setCandidateName(candidateDet.getName());
			resumeUploads.setProfilePath(filePath);
			try {
				getSession().saveOrUpdate(resumeUploads);
				result = "success~" + "200";
				return result;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				result = "error~" + "400";
				return result;
			}
		} else {
			result = "error~" + "400";
			return result;
		}
	}
}