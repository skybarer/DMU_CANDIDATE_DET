package com.hcl.dmu.batch.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.hcl.dmu.batch.entity.BatchEntity;
import com.hcl.dmu.reg.dao.AbstractDAO;

@Repository
public class BatchDaoImpl extends AbstractDAO implements BatchDao {

	@Override
	public String saveFilePath(String filePath) {
		String result = "";
		try {
			BatchEntity entity = new BatchEntity();
			entity.setBatchFilePath(filePath);
			getSession().saveOrUpdate(entity);
			result = "success";
			return result;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	@Override
	public String getFilePath(){
		Session session = null;
		String result = "";
		try {
			session = getSession();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<BatchEntity> criteriaQuery = cb.createQuery(BatchEntity.class);
			criteriaQuery.from(BatchEntity.class);
			Root<BatchEntity> root = criteriaQuery.from(BatchEntity.class);
			criteriaQuery.select(root).orderBy(cb.desc(root.get("createdDate")));
			List<BatchEntity> list = session.createQuery(criteriaQuery).getResultList();
			if(!CollectionUtils.isEmpty(list)){
				result = list.get(0).getBatchFilePath();
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return result;
	}
}
