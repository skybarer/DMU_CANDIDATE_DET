package com.hcl.dmu.email.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.dozer.Mapper;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.dmu.email.entity.EmailEntity;
import com.hcl.dmu.email.entity.EmailLogEntity;
import com.hcl.dmu.email.vo.EmailLogVo;
import com.hcl.dmu.email.vo.EmailVo;
import com.hcl.dmu.reg.dao.AbstractDAO;
import com.hcl.dmu.reg.entity.ProfileSummaryEntity;

@Repository
public class EmailConfigurationDaoImpl extends AbstractDAO implements EmailConfigurationDao {

	private static final Logger log = LoggerFactory.getLogger(EmailConfigurationDaoImpl.class);

	@Autowired
	private Mapper mapper;
	
	@Override
	public EmailVo getEmailDetails() {
		Session session = null;
		CriteriaQuery<EmailEntity> criteriaQuery = null;
		EmailEntity emailEntity = null;
		EmailVo emailVo = null;
		try {
			session = getSession();
			criteriaQuery = session.getCriteriaBuilder().createQuery(EmailEntity.class);
			criteriaQuery.from(EmailEntity.class);
			List<EmailEntity> resultList = session.createQuery(criteriaQuery).getResultList();
			if(!resultList.isEmpty())
				emailEntity = resultList.get(0); 
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		if(emailEntity!=null){
			emailVo = new EmailVo();
			mapper.map(emailEntity, emailVo);
		}
		return emailVo;
	}
	
	@Override
	public EmailLogVo getEmailTemplateDetails(){
		Session session = null;
		CriteriaQuery<EmailLogEntity> criteriaQuery = null;
		EmailLogEntity emailEntity = null;
		EmailLogVo EmailLogVo = null;
		try {
			session = getSession();
			criteriaQuery = session.getCriteriaBuilder().createQuery(EmailLogEntity.class);
			criteriaQuery.from(EmailLogEntity.class);
			List<EmailLogEntity> resultList = session.createQuery(criteriaQuery).getResultList();
			if(!resultList.isEmpty())
				emailEntity = resultList.get(0); 
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		if(emailEntity!=null){
			EmailLogVo = new EmailLogVo();
			mapper.map(emailEntity, EmailLogVo);
		}
		return EmailLogVo;
}

	@Override
	public String insertEmailTemplateDetails(EmailLogVo templateVO) {
		Session session = null;
		String result;
		Serializable response = null;
		CriteriaQuery<EmailLogEntity> criteriaQuery = null;
		EmailLogEntity emailEntity = null;
		try {
			session = getSession();
			emailEntity = new EmailLogEntity();
			mapper.map(templateVO, emailEntity);
			response = session.save(emailEntity);
			response = "200";
				result = "success~" + response;
			}	
		
		catch (Exception e) {
			log.error(e.getMessage());
			System.out.println(e.getMessage());
			result = "error~" + "400";
			e.printStackTrace();
		}
	
		
		return result;
	}

	@Override
	public String updateEmailTemplateDetails(EmailLogVo templateVO) {
		Session session = null;
		String result = null;
		Serializable response = null;
		CriteriaQuery<EmailLogEntity> criteriaQuery = null;
		EmailLogEntity emailEntity = null;
		EmailLogVo EmailLogVo = null;
		try {
			session = getSession();
			emailEntity = new EmailLogEntity();
			criteriaQuery = session.getCriteriaBuilder().createQuery(EmailLogEntity.class);
			criteriaQuery.from(EmailLogEntity.class);
			List<EmailLogEntity> resultList = session.createQuery(criteriaQuery).getResultList();
			if(!resultList.isEmpty()){
				emailEntity = resultList.get(0); 
				Long id = templateVO.getId();
				mapper.map(templateVO, emailEntity);
				emailEntity.setId(id);
			} else {
				result = "error~" + "400";
				return result;
			}
			session.update(emailEntity);
			response = "200";
			result = "success~" + response;
			
		} catch (Exception e) {
			log.error(e.getMessage());
			result = "error~" + "400";
			e.printStackTrace();
		}
		return result;
	}
}
