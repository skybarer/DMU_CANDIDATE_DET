package com.hcl.dmu.utils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import com.hcl.dmu.reg.dao.AbstractDAO;



@Service
@Transactional

public class RecordCountUtility<obj> extends AbstractDAO{
	
	public  Long  getRecordCount(Object obj)
	{
		Session session = null;
		Long recordCount = null;
		try {
			session = getSession();
			CriteriaBuilder cb = session.getCriteriaBuilder();

			CriteriaQuery<Object> crt2 = cb.createQuery(Object.class);
			Root<obj> root2 = (Root<obj>) crt2.from(obj.getClass());
			crt2.select(cb.count(root2)); //Finding the total count of records 
			Query query2 = session.createQuery(crt2);
			 recordCount = (Long) query2.getSingleResult();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return  recordCount;
	}
	
	

}
