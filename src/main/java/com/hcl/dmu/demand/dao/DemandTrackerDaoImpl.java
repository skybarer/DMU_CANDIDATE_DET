package com.hcl.dmu.demand.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.dozer.Mapper;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.dmu.clientprocess.dao.ClientProcessDetailsDao;
import com.hcl.dmu.demand.entity.DemandDetailsEntity;
import com.hcl.dmu.demand.vo.DemandDetailsVo;
import com.hcl.dmu.reg.dao.AbstractDAO;

@Repository
public class DemandTrackerDaoImpl extends AbstractDAO implements DemandTrackerDao {

	private static final Logger log = LoggerFactory.getLogger(DemandTrackerDaoImpl.class);

	@Autowired
	private ClientProcessDetailsDao clientProcessDetailsDao;

	@Autowired
	private Mapper mapper;

	@Override
	public String insertDemandTracker(DemandDetailsVo demandDetailsVo) {

		Session session = null;
		DemandDetailsEntity demandTrackerEntity = null;
		String result = null;
		try {

			session = getSession();
			demandTrackerEntity = new DemandDetailsEntity();

			Serializable response = null;
			if (demandDetailsVo != null) {
				demandTrackerEntity.setStreamName(demandDetailsVo.getStreamName());
				demandTrackerEntity.setSubStreamName(demandDetailsVo.getSubStreamName());
				demandTrackerEntity.setSkillName(demandDetailsVo.getSkillName());
				demandTrackerEntity.setCount(demandDetailsVo.getCount());
				demandTrackerEntity.setFullfilled(demandDetailsVo.getFullfilled());
				demandTrackerEntity.setGap(demandDetailsVo.getCount() - demandDetailsVo.getFullfilled());
				response = session.save(demandTrackerEntity);
				result = "success~" + response;

			} else {
				result = "error~" + "400";

			}

		} catch (Exception e) {
			result = "error~" + "400";
			log.error(e.getMessage());
			e.printStackTrace();

		}
		log.info(result);
		return result;
	}

	@Override
	public String updateDemandTrackerDetails(DemandDetailsVo demandDetailsVo) {

		Session session = null;
		DemandDetailsEntity demandTrackerEntity = null;
		String result = null;
		if (demandDetailsVo != null && demandDetailsVo.getId() > 0) {
			session = getSession();
			demandTrackerEntity = this.findById(demandDetailsVo.getId());
			if (demandTrackerEntity != null) {
				demandTrackerEntity.setCount(demandDetailsVo.getCount());
				demandTrackerEntity.setFullfilled(demandDetailsVo.getFullfilled());
				demandTrackerEntity.setGap(demandDetailsVo.getCount() - demandDetailsVo.getFullfilled());
				session.update(demandTrackerEntity);
				result = "success~" + "200";
			} else {
				result = "error~" + "400";
			}

		} else {
			result = "error~" + "400";
		}

		return result;
	}

	@Override
	public DemandDetailsEntity findById(long id) {
		DemandDetailsEntity demandTrackEntity = null;
		try {
			log.info("DemandDetailsEntity :: " + id);
			Session session = getSession();
			Query<DemandDetailsEntity> query = session.createQuery("FROM DemandDetailsEntity where Id=:id");
			query.setParameter("id", id);
			demandTrackEntity = query.getSingleResult();
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info(demandTrackEntity.toString());
		return demandTrackEntity;
	}

	@Override
	public List<DemandDetailsVo> getAllDemandTrackerEntities() {
		Session session = null;
		List<DemandDetailsEntity> demandDetailsEntityList = null;
		CriteriaQuery<DemandDetailsEntity> criteriaQuery = null;
		List<DemandDetailsVo> demandDetailsVoList = new ArrayList<>();

		try {
			session = getSession();
			criteriaQuery = session.getCriteriaBuilder().createQuery(DemandDetailsEntity.class);
			criteriaQuery.from(DemandDetailsEntity.class);
			demandDetailsEntityList = session.createQuery(criteriaQuery).getResultList();

			if (demandDetailsEntityList != null && demandDetailsEntityList.size() > 0) {
				demandDetailsVoList = new ArrayList<DemandDetailsVo>();
				for (DemandDetailsEntity demandDetailsEntity : demandDetailsEntityList) {

					DemandDetailsVo demandDetailsVo = new DemandDetailsVo();
					mapper.map(demandDetailsEntity, demandDetailsVo);

					demandDetailsVo.setId(demandDetailsEntity.getId());
					demandDetailsVo.setCount(demandDetailsEntity.getCount());
					demandDetailsVo.setFullfilled(demandDetailsEntity.getFullfilled());
					demandDetailsVo.setGap(demandDetailsEntity.getGap());
					demandDetailsVo.setSkillName(demandDetailsEntity.getSkillName());
					demandDetailsVo.setStreamName(demandDetailsEntity.getStreamName());
					demandDetailsVo.setSubStreamName(demandDetailsEntity.getSubStreamName());
					demandDetailsVoList.add(demandDetailsVo);
				}
			}

		} catch (Exception e) {
			demandDetailsEntityList = null;
			e.printStackTrace();
		}
		return demandDetailsVoList;
	}

	@Override
	public List<DemandDetailsVo> searchDemandTrackerEntities(String skillName, String streamName,
			String subStreamName) {

		Session session = null;
		List<DemandDetailsEntity> demandTrackerEntityList = null;
		Query<DemandDetailsEntity> demandQuery = null;
		List<DemandDetailsVo> demandDetailsVoList = null;

		try {
			session = getSession();
			demandQuery = session.createQuery(
					"from DemandDetailsEntity where skill_name = :skillName and stream_name = :streamName and sub_stream_name = :subStreamName",
					DemandDetailsEntity.class);
			demandQuery.setParameter("skillName", skillName);
			demandQuery.setParameter("streamName", streamName);
			demandQuery.setParameter("subStreamName", subStreamName);

			demandTrackerEntityList = demandQuery.getResultList();

			if (demandTrackerEntityList != null && demandTrackerEntityList.size() > 0) {

				demandDetailsVoList = new ArrayList<DemandDetailsVo>();

				for (DemandDetailsEntity demandDetailsEntity : demandTrackerEntityList) {

					DemandDetailsVo demandDetailsVo = new DemandDetailsVo();
					mapper.map(demandDetailsEntity, demandDetailsVo);

					demandDetailsVo.setId(demandDetailsEntity.getId());
					demandDetailsVo.setCount(demandDetailsEntity.getCount());
					demandDetailsVo.setFullfilled(demandDetailsEntity.getFullfilled());
					demandDetailsVo.setGap(demandDetailsEntity.getGap());
					demandDetailsVo.setSkillName(demandDetailsEntity.getSkillName());
					demandDetailsVo.setStreamName(demandDetailsEntity.getStreamName());
					demandDetailsVo.setSubStreamName(demandDetailsEntity.getSubStreamName());
					demandDetailsVoList.add(demandDetailsVo);
				}

			}

		} catch (Exception e) {
			demandDetailsVoList = null;
			e.printStackTrace();
		}

		return demandDetailsVoList;
	}

}
