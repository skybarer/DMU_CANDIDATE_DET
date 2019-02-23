package com.hcl.dmu.email.service;

import com.hcl.dmu.email.vo.EmailLogVo;
import com.hcl.dmu.email.vo.EmailVo;

public interface EmailConfigurationService {

	EmailVo getEmailDetails();
	
	EmailLogVo getEmailTemplateDetails();

	String insertEmailTemplateDetails(EmailLogVo templateVO);

	String updateEmailTemplateDetails(EmailLogVo templateVO);

}
