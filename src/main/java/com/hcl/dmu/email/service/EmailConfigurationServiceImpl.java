package com.hcl.dmu.email.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dmu.email.dao.EmailConfigurationDao;
import com.hcl.dmu.email.vo.EmailLogVo;
import com.hcl.dmu.email.vo.EmailVo;

@Service
@Transactional
public class EmailConfigurationServiceImpl implements EmailConfigurationService {

	@Autowired
	private EmailConfigurationDao emailDao;
	
	@Override
	public EmailVo getEmailDetails() {
		return emailDao.getEmailDetails();
	}
	
	@Override
	public EmailLogVo getEmailTemplateDetails(){
		return emailDao.getEmailTemplateDetails();
	}

	@Override
	public String insertEmailTemplateDetails(EmailLogVo templateVO) {
		return emailDao.insertEmailTemplateDetails(templateVO);
	}

	@Override
	public String updateEmailTemplateDetails(EmailLogVo templateVO) {
		return emailDao.updateEmailTemplateDetails(templateVO);
	}

}
