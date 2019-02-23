package com.hcl.dmu.email.dao;

import com.hcl.dmu.email.vo.EmailLogVo;
import com.hcl.dmu.email.vo.EmailVo;

public interface EmailConfigurationDao {

	EmailVo getEmailDetails();

	EmailLogVo getEmailTemplateDetails();

	String insertEmailTemplateDetails(EmailLogVo templateVO);

	String updateEmailTemplateDetails(EmailLogVo templateVO);
}
