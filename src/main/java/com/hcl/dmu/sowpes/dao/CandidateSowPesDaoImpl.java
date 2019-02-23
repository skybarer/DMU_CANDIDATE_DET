package com.hcl.dmu.sowpes.dao;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.dmu.clientprocess.entity.CandidateClientProcessEntity;
import com.hcl.dmu.clientprocess.vo.CandidateClientProcessVo;
import com.hcl.dmu.reg.dao.AbstractDAO;
import com.hcl.dmu.sowpes.entity.CandidateSowPesEntity;
import com.hcl.dmu.sowpes.vo.CandidateSowPesVo;

@Repository
public class CandidateSowPesDaoImpl extends AbstractDAO implements CandidateSowPesDao {

	@Autowired
	private Mapper mapper;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	@Override
	public List<CandidateClientProcessVo> getAllClientSelectedDetails() {
		Session session = null;
		List<CandidateClientProcessVo> candidateClientProcessVoList = null;
		try {
			session = getSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<CandidateClientProcessEntity> criteria = builder
					.createQuery(CandidateClientProcessEntity.class);
			Root<CandidateClientProcessEntity> candidateClientProcess = criteria
					.from(CandidateClientProcessEntity.class);
			CriteriaQuery<CandidateClientProcessEntity> select = criteria.select(candidateClientProcess);
			criteria.where(builder.equal(candidateClientProcess.get("status"),"selected"));
			 session
					  .getCriteriaBuilder();
					CriteriaQuery<CandidateClientProcessEntity> query = builder
					  .createQuery(CandidateClientProcessEntity.class);
					TypedQuery<CandidateClientProcessEntity> typedQuery = session.createQuery(select);
					List<CandidateClientProcessEntity> candidateList = typedQuery.getResultList();
				
			if (candidateList != null && candidateList.size() > 0) {
				candidateClientProcessVoList = new ArrayList<CandidateClientProcessVo>();
				for (CandidateClientProcessEntity candidateClientProcessEntity : candidateList) {
					CandidateClientProcessVo candidateClientProcessVo = new CandidateClientProcessVo();
					mapper.map(candidateClientProcessEntity, candidateClientProcessVo);
					candidateClientProcessVo.setClientInterviewDate(sdf.format(candidateClientProcessEntity.getClientInterviewDate()));
					candidateClientProcessVo.setClientProcessId(candidateClientProcessEntity.getId());
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
	public int updateSelectedDetails(CandidateSowPesVo candidateSowPesVo) {
		return 0;
	}
	
	@Override
	public int insertSelectedCandidateDetails(List<CandidateSowPesVo> candidateSowPesVoList) {
		Session session = null;
		int count = 0;
		try {
			session = getSession();
			if(candidateSowPesVoList!=null && !candidateSowPesVoList.isEmpty()) {
				Query<CandidateClientProcessEntity> query = session.createQuery("update CandidateClientProcessEntity set status=:status where id=:id");
				for (CandidateSowPesVo candidateSowPesVo : candidateSowPesVoList) {
					CandidateSowPesEntity candidateSowPesEntity = new CandidateSowPesEntity();
					mapper.map(candidateSowPesVo, candidateSowPesEntity);
					session.save(candidateSowPesEntity);
					query.setParameter("status", candidateSowPesVo.getStatus());
					query.setParameter("id", candidateSowPesVo.getClientProcessId());
					query.executeUpdate();
					count++;
				}
			}else {
				count = 0;
			}
		} catch (Exception e) {
			count = 0;
			e.printStackTrace();
		}
		return count;
	}

	
	@Override
	public List<CandidateSowPesVo> getCandidateSowPesDetails() {
		Session session = null;
		List<CandidateSowPesVo> candidateSowPesVoList = new ArrayList<>();
		CandidateSowPesVo candidateSowPesVo = null;
		try {
			session = getSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<CandidateSowPesEntity> criteria = builder
					.createQuery(CandidateSowPesEntity.class);
			Root<CandidateSowPesEntity> candidateSowPesEntity = criteria
					.from(CandidateSowPesEntity.class);
			CriteriaQuery<CandidateSowPesEntity> select = criteria.select(candidateSowPesEntity);
		 session
					  .getCriteriaBuilder();
					CriteriaQuery<CandidateSowPesEntity> query = builder
					  .createQuery(CandidateSowPesEntity.class);
					TypedQuery<CandidateSowPesEntity> typedQuery = session.createQuery(select);
					List<CandidateSowPesEntity> candidateSowPesList = typedQuery.getResultList();
			if (candidateSowPesList != null && candidateSowPesList.size() > 0) {
				candidateSowPesVoList = new ArrayList<CandidateSowPesVo>();
				for (CandidateSowPesEntity entity : candidateSowPesList) {
					candidateSowPesVo = new CandidateSowPesVo();
					mapper.map(entity, candidateSowPesVo);
					candidateSowPesVoList.add(candidateSowPesVo);
				}
			}
		} catch (Exception e) {
			candidateSowPesVoList = null;
			e.printStackTrace();
		}
		return candidateSowPesVoList;
	}

	@Override
	public int updateCandidateSowPesDetails(List<CandidateSowPesVo> candidateSowPesVoList) {
		Session session = null;
		int count = 0;
		try {
			session = getSession();
			if(candidateSowPesVoList!=null && !candidateSowPesVoList.isEmpty()) {
				for (CandidateSowPesVo candidateSowPesVo : candidateSowPesVoList) {
					CandidateSowPesEntity candidateSowPesEntity = new CandidateSowPesEntity();
					mapper.map(candidateSowPesVo, candidateSowPesEntity);
					session.update(candidateSowPesEntity);
					count++;
				}
			}else {
				count = 0;
			}
		} catch (Exception e) {
			count = 0;
			e.printStackTrace();
		}
		return count;
	}
}
