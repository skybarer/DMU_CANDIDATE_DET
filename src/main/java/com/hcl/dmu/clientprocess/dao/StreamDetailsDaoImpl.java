package com.hcl.dmu.clientprocess.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.dozer.Mapper;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.dmu.clientprocess.entity.StreamEntity;
import com.hcl.dmu.clientprocess.entity.SubStreamEntity;
import com.hcl.dmu.clientprocess.vo.StreamEntityVo;
import com.hcl.dmu.clientprocess.vo.SubStreamEntityVo;
import com.hcl.dmu.reg.dao.AbstractDAO;


@Repository
public class StreamDetailsDaoImpl extends AbstractDAO implements StreamDao{
	
	@Autowired
	private Mapper mapper;
	
	@Override
	public List<StreamEntityVo> getAllStreamDetails() {
		Session session = null;
		List<StreamEntity> streamEntityList = null;
		List<StreamEntityVo> streamEntityVo = null;
		try {
			session = getSession();
			Query<StreamEntity> createQuery = session.createQuery("from StreamEntity");
			streamEntityList = createQuery.getResultList();
			System.out.println("dao"+streamEntityList);
			if (streamEntityList != null && streamEntityList.size() > 0) {
				streamEntityVo = new ArrayList<StreamEntityVo>();
				for (StreamEntity sEntity : streamEntityList) {
					StreamEntityVo streamEntity =new StreamEntityVo();
					mapper.map(sEntity, streamEntity);
					streamEntityVo.add(streamEntity);
				}
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		System.out.println("dao"+streamEntityVo);
		return streamEntityVo;
	}


	@Override
	public List<SubStreamEntityVo> getAllSubStreamDetails(String streamName) {
		Session session = null;
		List<SubStreamEntity> streamEntityList = null;
		List<SubStreamEntityVo> streamEntityVo = null;
		try {
			session = getSession();
			Query<SubStreamEntity> createQuery = session.createQuery("from SubStreamEntity where streamEntity.streamName=:streamName");
			createQuery.setParameter("streamName", streamName);
			streamEntityList = createQuery.getResultList();
			System.out.println("dao"+streamEntityList);
			if (streamEntityList != null && streamEntityList.size() > 0) {
				streamEntityVo = new ArrayList<SubStreamEntityVo>();
				for (SubStreamEntity sEntity : streamEntityList) {
					SubStreamEntityVo streamEntity =new SubStreamEntityVo();
					mapper.map(sEntity, streamEntity);
					streamEntityVo.add(streamEntity);
				}
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		System.out.println("dao"+streamEntityVo);
		return streamEntityVo;
	}
	
	

}
