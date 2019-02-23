package com.hcl.dmu.clientprocess.dao;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.dozer.Mapper;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.dmu.clientprocess.entity.CandidateClientProcessEntity;
import com.hcl.dmu.clientprocess.vo.CandidateClientProcessSearchVO;
import com.hcl.dmu.clientprocess.vo.CandidateClientProcessVo;
import com.hcl.dmu.config.EmailService;
import com.hcl.dmu.reg.dao.AbstractDAO;

@Repository
public class ClientProcessDetailsDaoImpl extends AbstractDAO implements ClientProcessDetailsDao {

	private static final Logger log = LoggerFactory.getLogger(ClientProcessDetailsDaoImpl.class);

	private static final String INSERT_QUERY = "insert into dmu_client_process_details(candidate_id,mobile_no,"
			+ "contact_person,status,name,primary_skill,secondary_skill,experience_yrs,experience_months,created_date,modified_date) "
			+ "(select id,contact_number,hr_contact_person,'Shortlisted for Interview',name,primary_skill,secondary_skill,"
			+ "exp_years,exp_months,NOW(),NOW() from dmu_candidate_details where id in (:ids) and id not in "
			+ "(select candidate_id from dmu_client_process_details))";

     @Autowired
	 private Mapper mapper;
	
	@Autowired
	private EmailService emailService;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public List<CandidateClientProcessVo> getAllClientProcessDetails(long pagenum) {
		Session session = null;
		
		List<CandidateClientProcessEntity> candidateClientProcessEntityList = null;
		CriteriaQuery<CandidateClientProcessEntity> criteriaQuery = null;
		List<CandidateClientProcessVo> candidateClientProcessVoList = null;
		try {
			session = getSession();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			criteriaQuery = cb.createQuery(CandidateClientProcessEntity.class);
			Root<CandidateClientProcessEntity> root = criteriaQuery.from(CandidateClientProcessEntity.class);
			Expression<String> exp = root.get("status");
			Predicate predicate = exp.in(Arrays.asList("Shortlisted for Interview", "Hold", "Scheduled", "Rejected", "Selected"));
			criteriaQuery.where(predicate);
			criteriaQuery.orderBy(cb.desc(root.get("modifiedDate")));
			CriteriaQuery<CandidateClientProcessEntity> select = criteriaQuery.select(root);
					TypedQuery<CandidateClientProcessEntity> typedQuery = session.createQuery(select);
					typedQuery.setFirstResult((int) ((pagenum-1)*10));
					typedQuery.setMaxResults(10);
					candidateClientProcessEntityList = typedQuery.getResultList();
			if (candidateClientProcessEntityList != null && candidateClientProcessEntityList.size() > 0) {
				candidateClientProcessVoList = new ArrayList<CandidateClientProcessVo>();
				for (CandidateClientProcessEntity candidateClientProcessEntity : candidateClientProcessEntityList) {
					CandidateClientProcessVo candidateClientProcessVo = new CandidateClientProcessVo();
					mapper.map(candidateClientProcessEntity, candidateClientProcessVo);
					candidateClientProcessVo
							.setClientProcessId(candidateClientProcessEntity.getCandidateDetEntity().getId());
					if (candidateClientProcessEntity.getClientInterviewDate() != null)
						candidateClientProcessVo.setClientInterviewDate(
								sdf.format(candidateClientProcessEntity.getClientInterviewDate()));
					if (candidateClientProcessEntity.getExpYrs() != null)
						candidateClientProcessVo.setExpYrs(String.valueOf(candidateClientProcessEntity.getExpYrs()));
					if (candidateClientProcessEntity.getExpMonths() != null)
						candidateClientProcessVo
								.setExpMonths(String.valueOf(candidateClientProcessEntity.getExpMonths()));
					candidateClientProcessVoList.add(candidateClientProcessVo);
				}
			}
		} catch (Exception e) {
			candidateClientProcessVoList = null;
			e.printStackTrace();
		}
		return candidateClientProcessVoList;
	}

	@Override
	public int insertClientProcessDetails(List<Long> ids) {
		Session session = null;
		int executeUpdate = 0;
		Query<?> insertQuery = null;
		try {
			session = getSession();
			if (ids != null && ids.size() > 0) {
				insertQuery = session.createNativeQuery(INSERT_QUERY);
				insertQuery.setParameter("ids", ids);
				executeUpdate = insertQuery.executeUpdate();
				System.out.println(executeUpdate);
			} else {
				executeUpdate = 0;
			}
		} catch (Exception e) {
			executeUpdate = 0;
			e.printStackTrace();
		}
		return executeUpdate;
	}

	@Override
	public CandidateClientProcessEntity findById(Long id) {
		Session session = null;
		CandidateClientProcessEntity candidateDetEntity = null;
		try {
			log.info("CandidateClientProcessEntity :: " + id);
			session = getSession();
			@SuppressWarnings("unchecked")
			Query<CandidateClientProcessEntity> query = session
					.createQuery("FROM CandidateClientProcessEntity where id=:id");
			query.setParameter("id", id);
			candidateDetEntity = query.getSingleResult();
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info(candidateDetEntity.toString());
		return candidateDetEntity;
	}

	public List<CandidateClientProcessVo> searchClientProcessDetails(CandidateClientProcessSearchVO searchVO) {
		List<CandidateClientProcessVo> candidateClientProcessVoList = null;

		Session session = null;
		try {

			session = getSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<CandidateClientProcessEntity> criteria = builder
					.createQuery(CandidateClientProcessEntity.class);
			Root<CandidateClientProcessEntity> candidateClientProcess = criteria
					.from(CandidateClientProcessEntity.class);
			criteria.select(candidateClientProcess);
			criteria.where(
					builder.like(candidateClientProcess.get("candidateName"), "%" + searchVO.getCandidateName() + "%"));
			if (!searchVO.getMobileNo().isEmpty())
				criteria.where(
						builder.equal(candidateClientProcess.get("mobileNo"), Long.valueOf(searchVO.getMobileNo())));
			if (!searchVO.getStatus().isEmpty())
				criteria.where(builder.equal(candidateClientProcess.get("status"), searchVO.getStatus()));
			if (!searchVO.getStream().isEmpty())
				criteria.where(builder.equal(candidateClientProcess.get("stream"), searchVO.getStream()));
			if (!searchVO.getSkill().isEmpty())
				criteria.where(builder.equal(candidateClientProcess.get("skill"), searchVO.getSkill()));
			if (!searchVO.getExpFrom().isEmpty() && !searchVO.getExpTo().isEmpty()) {
				criteria.where(builder.between(candidateClientProcess.get("experienceYrs"), searchVO.getExpFrom(),
						searchVO.getExpTo()));
			}
			if (!searchVO.getDateFrom().isEmpty() && !searchVO.getDateTo().isEmpty()) {
				criteria.where(builder.between(candidateClientProcess.get("clientInterviewDate"),
						sdf.parse(searchVO.getDateFrom()), sdf.parse(searchVO.getDateTo())));
			}
			List<CandidateClientProcessEntity> candidateList = session.createQuery(criteria).getResultList();
			if (candidateList != null && !candidateList.isEmpty()) {

				candidateClientProcessVoList = new ArrayList<CandidateClientProcessVo>();

				for (CandidateClientProcessEntity candidateClientProcessEntity : candidateList) {
					CandidateClientProcessVo candidateClientProcessVo = new CandidateClientProcessVo();
					mapper.map(candidateClientProcessEntity, candidateClientProcessVo);
					candidateClientProcessVo
							.setClientInterviewDate(sdf.format(candidateClientProcessEntity.getClientInterviewDate()));
					candidateClientProcessVo.setClientProcessId(candidateClientProcessEntity.getId());
					candidateClientProcessVoList.add(candidateClientProcessVo);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}

		return candidateClientProcessVoList;
	}

	@Override
	public int updateClientProcessDetails(CandidateClientProcessVo candidateClientProcessVo) {
		int count = 0;
		Session session = null;
		String interviewDateTime = null;

		try {
			session = getSession();
			CandidateClientProcessEntity findById = this.findById(candidateClientProcessVo.getId());
			interviewDateTime = candidateClientProcessVo.getClientInterviewDate();
			candidateClientProcessVo.setClientInterviewDate("");
			mapper.map(candidateClientProcessVo, findById);
			if (!interviewDateTime.isEmpty()) {
				findById.setClientInterviewDate(new Timestamp(sdf.parse(interviewDateTime).getTime()));
			}
			if (candidateClientProcessVo.getExpYrs() != null)
				findById.setExpYrs(Long.valueOf(candidateClientProcessVo.getExpYrs()));
			if (candidateClientProcessVo.getExpMonths() != null)
				findById.setExpMonths(Long.valueOf(candidateClientProcessVo.getExpMonths()));

			findById.setModifiedDate(new Timestamp(new Date().getTime()));
			session.update(findById);
			count = 1;
			StringBuilder emailSub = new StringBuilder();
			emailSub.append("Interview Date : ").append(candidateClientProcessVo.getClientInterviewDate())
			.append(" : ")
			.append(candidateClientProcessVo.getClientInterviewTime());
			emailService.sendSimpleMessage("sekhar.k@hcl.com",findById.getCandidateDetEntity().getEmailId(),  emailSub.toString(), "Please attend the interview as per Scheduled",null,null);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return count;
	}

}
