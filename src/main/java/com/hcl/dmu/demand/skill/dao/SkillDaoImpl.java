
package com.hcl.dmu.demand.skill.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.dozer.Mapper;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.dmu.demand.entity.DemandDetailsEntity;
import com.hcl.dmu.demand.entity.PrimarySkillEntity;
import com.hcl.dmu.demand.entity.SecondarySkillEntity;
import com.hcl.dmu.demand.entity.SkillsEntity;
import com.hcl.dmu.demand.vo.DemandTrakerVo;
import com.hcl.dmu.demand.vo.PrimarySkillVo;
import com.hcl.dmu.demand.vo.SecondarySkillVo;
import com.hcl.dmu.demand.vo.SkillVo;
import com.hcl.dmu.reg.dao.AbstractDAO;

@Repository
public class SkillDaoImpl extends AbstractDAO implements SkillDao {

	private static final Logger log = LoggerFactory.getLogger(SkillDaoImpl.class);

	@Autowired
	private Mapper mapper;

	@Override
	public List<DemandTrakerVo> getSkillDemandDetails() {

		Session session = null;
		List<DemandTrakerVo> listDemandTrakerVo = null;

		try {
			session = getSession();
			Query<DemandDetailsEntity> createQuery = session.createQuery("from DemandDetailsEntity");
			List<DemandDetailsEntity> resultList = createQuery.getResultList();
			if (resultList != null && resultList.size() > 0) {
				listDemandTrakerVo = new ArrayList<DemandTrakerVo>();
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();

		}
		log.info(listDemandTrakerVo.toString());

		return listDemandTrakerVo;
	}

	@Override
	public List<SkillVo> getAllSkillDetails() {

		Session session = null;
		List<SkillVo> listSkillSetVo = null;
		try {
			session = getSession();
			Query<SkillsEntity> createQuery = session.createQuery("from SkillsEntity e ");
			List<SkillsEntity> resultList = createQuery.getResultList();
			if (resultList != null && resultList.size() > 0) {
				listSkillSetVo = new ArrayList<SkillVo>();
				for (SkillsEntity skillsEntity : resultList) {
					SkillVo skillVo = new SkillVo();
					mapper.map(skillsEntity, skillVo);
					listSkillSetVo.add(skillVo);
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();

		}
		log.info(listSkillSetVo.toString());

		return listSkillSetVo;

	}

	@Override
	public SkillsEntity findById(Long id) {
		SkillsEntity skillEntity = null;
		try {

			skillEntity = getSession().get(SkillsEntity.class, id);

		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}

		log.info(skillEntity.toString());
		return skillEntity;
	}

	@Override
	public List<PrimarySkillVo> getPrimarySkills() {
		Session session = null;
		List<PrimarySkillVo> primarySkillVos = null;
		CriteriaQuery<PrimarySkillEntity> criteriaQuery = null;
		try {
			session = getSession();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			criteriaQuery = cb.createQuery(PrimarySkillEntity.class);
			criteriaQuery.from(PrimarySkillEntity.class);
			List<PrimarySkillEntity> resultList = session.createQuery(criteriaQuery).getResultList();
			if (resultList != null && resultList.size() > 0) {
				primarySkillVos = new ArrayList<PrimarySkillVo>();
				for (PrimarySkillEntity primarySkillEntity : resultList) {
					PrimarySkillVo primarySkillVo = new PrimarySkillVo();
					mapper.map(primarySkillEntity, primarySkillVo);
					primarySkillVos.add(primarySkillVo);
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();

		}
		return primarySkillVos;
	}

	@Override
	public List<SecondarySkillVo> getSecondarySkills(String skillName) {
		Session session = null;
		List<SecondarySkillVo> secondarySkillVos = null;
		try {
			session = getSession();
			@SuppressWarnings("unchecked")
			Query<SecondarySkillEntity> createQuery = session.createQuery("From SecondarySkillEntity where primarySkillEntity.primarySkillName=:skillName");
			createQuery.setParameter("skillName", skillName);
			List<SecondarySkillEntity> resultList = createQuery.getResultList();
			if (resultList != null && resultList.size() > 0) {
				secondarySkillVos = new ArrayList<SecondarySkillVo>();
				for (SecondarySkillEntity secondarySkillEntity : resultList) {
					SecondarySkillVo secondarySkillVo = new SecondarySkillVo();
					mapper.map(secondarySkillEntity, secondarySkillVo);
					secondarySkillVos.add(secondarySkillVo);
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();

		}
		return secondarySkillVos;
	}
	
}
