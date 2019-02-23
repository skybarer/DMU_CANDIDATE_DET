package com.hcl.dmu.demand.stream.dao;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.dmu.demand.entity.DemandStreamEntity;
import com.hcl.dmu.demand.entity.SkillsEntity;
import com.hcl.dmu.demand.skill.dao.SkillDaoImpl;
import com.hcl.dmu.demand.vo.DemandStreamVo;
import com.hcl.dmu.reg.dao.AbstractDAO;

@Repository
public class StreamDaoImpl extends AbstractDAO implements StreamDao {

	private static final Logger log = LoggerFactory.getLogger(SkillDaoImpl.class);

	@Autowired
	private Mapper mapper;

	@Override
	public List<DemandStreamVo> getAllStreamDetails() {
		Session session = null;
		List<DemandStreamVo> listDemandStreamVo = null;
		try {
			session = getSession();
			Query<DemandStreamEntity> createQuery = session.createQuery("from DemandStreamEntity e ");
			List<DemandStreamEntity> resultList = createQuery.getResultList();
			if (resultList != null && resultList.size() > 0) {
				listDemandStreamVo = new ArrayList<DemandStreamVo>();
				for (DemandStreamEntity entity : resultList) {
					DemandStreamVo demandStreamVo = new DemandStreamVo();
					mapper.map(entity, demandStreamVo);
					listDemandStreamVo.add(demandStreamVo);
				}

			}

		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();

		}
		log.info(listDemandStreamVo.toString());

		return listDemandStreamVo;

	}
	
	
	@Override
	public DemandStreamEntity findById(Long id) {
		DemandStreamEntity deandStreamEntity = null;
		try {

			deandStreamEntity = getSession().get(DemandStreamEntity.class, id);

		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info(deandStreamEntity.toString());
		return deandStreamEntity;
	}

}
