/**
 * 
 */
package com.hcl.dmu.reg.dao;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.dozer.Mapper;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.hcl.dmu.clientprocess.entity.CandidateClientProcessEntity;
import com.hcl.dmu.reg.entity.CandidateDetEntity;
import com.hcl.dmu.reg.entity.ProfileSummaryEntity;
import com.hcl.dmu.reg.entity.ResumeUploadsEntity;
import com.hcl.dmu.reg.vo.CandidateDet;
import com.hcl.dmu.reg.vo.ProfileSummaryVo;
import com.hcl.dmu.reg.vo.ResumeUploads;
import com.hcl.dmu.utils.ProfileUtils;

/**
 * @author sekhar.k
 *
 */

@Repository
public class CandaidateDetDAOImpl extends AbstractDAO implements CandaidateDetDAO {

	private static final Logger log = LoggerFactory.getLogger(CandaidateDetDAOImpl.class);

	@Autowired
	private Mapper mapper;

	@Autowired
	private ProfileUtils profileUtils;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public String insertCandidateDetails(CandidateDet candidateDet, MultipartFile file) throws Exception {
		String result;
		Serializable response = null;
		String interviewDateTime = "";
		CandidateDetEntity candidateDetEntity = null;
		try {
			candidateDetEntity = new CandidateDetEntity();
			interviewDateTime = candidateDet.getInterviewDateTime();
			candidateDet.setInterviewDateTime("");
			mapper.map(candidateDet, candidateDetEntity);
			candidateDetEntity.setCreatedDate(new Timestamp(System.currentTimeMillis()));
			if (!interviewDateTime.isEmpty())
				candidateDetEntity.setInterviewDateTime(new Timestamp(sdf.parse(interviewDateTime).getTime()));
			ResumeUploadsEntity reEntity = new ResumeUploadsEntity();
			if (file != null) {
				String filePath = profileUtils.getUploadedFilePath(candidateDet.getName(), file);
				reEntity.setCandidateName(candidateDet.getName());
				reEntity.setProfilePath(filePath);
				reEntity.setCandidateDetEntity(candidateDetEntity);
				candidateDetEntity.setResumeUploads(reEntity);
			}
			response = getSession().save(candidateDetEntity);
			if (response != null) {
				result = "success~" + response;
			} else {
				result = "error~" + "400";
			}
			System.out.println("response " + response.toString());

		} catch (Exception e) {
			log.error(e.getMessage());
			System.out.println(e.getMessage());
			result = "error~" + "400";
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<CandidateDet> getCandidateDetails(long pagenum) {
		Session session = null;
		List<CandidateDetEntity> candidateDetEntityList = null;
		CriteriaQuery<CandidateDetEntity> criteriaQuery = null;
		List<CandidateDet> candidateDetList = null;
		try {
			session = getSession();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			criteriaQuery = cb.createQuery(CandidateDetEntity.class);
			criteriaQuery.from(CandidateDetEntity.class);
			Root<CandidateDetEntity> root = criteriaQuery.from(CandidateDetEntity.class);
			CriteriaQuery<CandidateDetEntity> select = criteriaQuery.select(root).orderBy(cb.desc(root.get("createdDate"))).distinct(true);
			TypedQuery<CandidateDetEntity> typedQuery = session.createQuery(select);
			typedQuery.setFirstResult((int) ((pagenum-1)*10));
			typedQuery.setMaxResults(10);
			candidateDetEntityList = typedQuery.getResultList();
			if (candidateDetEntityList != null && candidateDetEntityList.size() > 0) {
				candidateDetList = new ArrayList<CandidateDet>();
				for (CandidateDetEntity candidateDetEntity : candidateDetEntityList) {
					CandidateDet candidateDet = new CandidateDet();
					mapper.map(candidateDetEntity, candidateDet);
					candidateDet.setCurrentCTC(candidateDetEntity.getCureentCTC());
					if (candidateDet.getInterviewDateTime() != null) {
						candidateDet
								.setInterviewDateTime(candidateDetEntity.getInterviewDateTime().toString());
					}
					candidateDetList.add(candidateDet);
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
		return candidateDetList;
	}

	@Override
	public String modifyCandidateDetails(CandidateDet candidateDet, MultipartFile file) throws Exception {

		String result;
		Session session = null;

		String interviewDateTime = null;
		session = getSession();

		CandidateDetEntity candidateDetEntity = findById(candidateDet.getId());
		if (candidateDetEntity != null) {

			interviewDateTime = candidateDet.getInterviewDateTime();
			candidateDet.setInterviewDateTime("");
			mapper.map(candidateDet, candidateDetEntity);
			if (!interviewDateTime.isEmpty()) {
				candidateDetEntity.setInterviewDateTime(new Timestamp(sdf.parse(interviewDateTime).getTime()));
			}
			ResumeUploadsEntity reEntity = candidateDetEntity.getResumeUploads();
			ResumeUploads resumeUploadsVo = candidateDet.getResumeUploads();
			reEntity = reEntity != null ? reEntity : new ResumeUploadsEntity();
			if (file != null && resumeUploadsVo != null) {
				String filePath = profileUtils.getUploadedFilePath(candidateDet.getName(), file);
				reEntity.setId(candidateDet.getResumeUploads().getId());
				reEntity.setCandidateName(candidateDet.getName());
				reEntity.setProfilePath(filePath);
				reEntity.setCandidateDetEntity(candidateDetEntity);
				candidateDetEntity.setResumeUploads(reEntity);
			} else if (resumeUploadsVo != null) {
				reEntity.setId(candidateDet.getResumeUploads().getId());
				reEntity.setCandidateName(candidateDet.getName());
				reEntity.setProfilePath(candidateDet.getResumeUploads().getProfilePath());
				reEntity.setCandidateDetEntity(candidateDetEntity);
				candidateDetEntity.setResumeUploads(reEntity);
			}else if (file != null) {
				reEntity.setCandidateName(candidateDet.getName());
				reEntity.setProfilePath(profileUtils.getUploadedFilePath(candidateDet.getName(), file));
				reEntity.setCandidateDetEntity(candidateDetEntity);
				candidateDetEntity.setResumeUploads(reEntity);
			}
			
		}

		try {
			if (candidateDetEntity != null) {
				session.update(candidateDetEntity);
				result = "success~" + "200";

			} else {
				result = "error~" + "200";
			}

		} catch (Exception e) {
			log.error(e.getMessage());
			System.out.println(e.getMessage());
			result = "error~" + "400";

		}
		log.info(result);
		return result;
	}

	@Override
	public CandidateDetEntity findById(Long id) {
		CandidateDetEntity candidateDetEntity = null;
		try {

			candidateDetEntity = getSession().get(CandidateDetEntity.class, id);

		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return candidateDetEntity;
	}

	@Override
	public int changeCandidateStatus(List<Long> ids) {
		int executeUpdate = 0;
		try {
			Query updateQuery = getSession().createQuery(
					"update CandidateDetEntity c set c.status='Shortlisted for Interview' where c.id in (:ids)");
			updateQuery.setParameter("ids", ids);
			executeUpdate = updateQuery.executeUpdate();
			log.info("updated Successfully");

		} catch (Exception e) {

			log.error("update failed");
			e.printStackTrace();
		}

		return executeUpdate;
	}

	@Override
	public int initiateHackerRank(List<Long> ids) {
		int executeUpdate = 0;
		try {
			Session session = getSession();
			Query updateQuery = getSession().createQuery(
					"update CandidateDetEntity c set c.status='Shortlisted for Hackerrank' where c.id in (:ids)");
			updateQuery.setParameter("ids", ids);
			executeUpdate = updateQuery.executeUpdate();
			log.info("updated Successfully");
		} catch (Exception e) {
			log.error("update failed");
			e.printStackTrace();
		}
		return executeUpdate;
	}

	@Override
	public String insertProfileSummaryDetails(ProfileSummaryVo profileSummaryVo,MultipartFile photo) {
		String result;
		Serializable response = null;
		ProfileSummaryEntity profileSummaryEntity = null;
		CriteriaQuery<ProfileSummaryEntity> criteriaQuery = null;
		try {
			session = getSession();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			criteriaQuery = cb.createQuery(ProfileSummaryEntity.class);
			criteriaQuery.from(ProfileSummaryEntity.class);
			Root<ProfileSummaryEntity> root = criteriaQuery.from(ProfileSummaryEntity.class);
			criteriaQuery = criteriaQuery.select(root).where(cb.equal(root.get("candidateId"), profileSummaryVo.getCandidateId()));
			List<ProfileSummaryEntity> profileSummaryEntities = session.createQuery(criteriaQuery).getResultList();
			if(profileSummaryEntities.isEmpty()){
				profileSummaryEntity = new ProfileSummaryEntity();
				mapper.map(profileSummaryVo, profileSummaryEntity);	
				if (photo != null) {
					String filePath = profileUtils.getUploadedFilePath(profileSummaryVo.getCandidateId().toString(), photo);
					profileSummaryEntity.setPhoto(filePath);
				}
				response = session.save(profileSummaryEntity);
			}else{
				profileSummaryEntity = profileSummaryEntities.get(0);
				Long id = profileSummaryEntity.getId();
				String imagePath = profileSummaryEntity.getPhoto();
				mapper.map(profileSummaryVo, profileSummaryEntity);
				profileSummaryEntity.setId(id);
				if (photo != null) {
					String filePath = profileUtils.getUploadedFilePath(profileSummaryVo.getCandidateId().toString(), photo);
					profileSummaryEntity.setPhoto(filePath);
				}else{
					profileSummaryEntity.setPhoto(imagePath);
				}
				session.update(profileSummaryEntity);
				response = "200";
			}
			
			if (response != null) {
				result = "success~" + response;
			} else {
				result = "error~" + "400";
			}
			System.out.println("response " + response.toString());

		} catch (Exception e) {
			log.error(e.getMessage());
			System.out.println(e.getMessage());
			result = "error~" + "400";
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ProfileSummaryVo getProfileDetails(Long id) {
		Session session = null;
		List<ProfileSummaryEntity> profileSummaryEntity = null;
		CriteriaQuery<ProfileSummaryEntity> criteriaQuery = null;
		ProfileSummaryVo profileSummaryVo = null;
		try {
			session = getSession();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			criteriaQuery = cb.createQuery(ProfileSummaryEntity.class);
			criteriaQuery.from(ProfileSummaryEntity.class);
			Root<ProfileSummaryEntity> root = criteriaQuery.from(ProfileSummaryEntity.class);
			criteriaQuery.select(root).where(cb.equal(root.get("candidateId"), id));
			profileSummaryEntity = session.createQuery(criteriaQuery).getResultList();
			if (profileSummaryEntity != null && !profileSummaryEntity.isEmpty()) {
				profileSummaryVo = new ProfileSummaryVo();
				mapper.map(profileSummaryEntity.get(0), profileSummaryVo);
				CriteriaBuilder cb1 = session.getCriteriaBuilder();
				CriteriaQuery<CandidateDetEntity> criteriaQuery1 = cb1.createQuery(CandidateDetEntity.class);
				criteriaQuery1.from(CandidateDetEntity.class);
				Root<CandidateDetEntity> root1 = criteriaQuery1.from(CandidateDetEntity.class);
				criteriaQuery1.select(root1).where(cb1.equal(root1.get("id"), profileSummaryVo.getCandidateId()));
				CandidateDetEntity candidateDetEntity = session.createQuery(criteriaQuery1).getSingleResult();
				profileSummaryVo.setDesignation(candidateDetEntity.getDesignation());
				profileSummaryVo.setCandidateName(candidateDetEntity.getName());
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
		return profileSummaryVo;
	}

	@Override
	public Long getCandidateDetailsCount() {
		
		try {
			session = getSession();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Long> cqCount = cb.createQuery(Long.class);
			Root<CandidateDetEntity> entityRoot = cqCount.from(CandidateDetEntity.class);
			cqCount.select(cb.count(entityRoot));
			return session.createQuery(cqCount).getSingleResult();
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return 0L;
	}
}
