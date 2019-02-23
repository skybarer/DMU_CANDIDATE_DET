package com.hcl.dmu.reg.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hcl.dmu.config.EmailService;
import com.hcl.dmu.email.service.EmailConfigurationService;
import com.hcl.dmu.email.vo.EmailLogVo;
import com.hcl.dmu.reg.vo.ResponseVO;

@Controller
public class EmailTemplateController {
	
	private static final Logger log = LoggerFactory.getLogger(CandiadteDetController.class);
	
	@Autowired
	private EmailConfigurationService emailConfigurationService;
	
	@Autowired
	private EmailService emailService;
	
	@GetMapping(value = "/getEmailTemplateDetails")
	@ResponseBody
	public ResponseVO getEmailTemplateDetails() {
		ResponseVO responseVO = new ResponseVO();
		EmailLogVo EmailLogVo = null;
		try {
			EmailLogVo = emailConfigurationService.getEmailTemplateDetails();
			if (EmailLogVo != null ) {
				responseVO.setCode("200");
				responseVO.setMessage(EmailLogVo);

			} else {
				responseVO.setCode("200");
				responseVO.setMessage("Details are empty");
			}

		} catch (Exception e) {
			responseVO.setCode("404");
			responseVO.setMessage("Response not found");
			e.printStackTrace();
		}

		return responseVO;
	}
	
	@PostMapping("/insertEmailTemplateDetails")
	@ResponseBody
	
	public ResponseVO insertEmailTemplateDetails(@RequestBody EmailLogVo templateVO) {
		ResponseVO responseVO = new ResponseVO();
		try {
			String EmailLogVo = emailConfigurationService.insertEmailTemplateDetails(templateVO);
			
			if(EmailLogVo != null) {
				responseVO.setCode("200");
				responseVO.setMessage(EmailLogVo+"Record (s) posted successfully");
			}else {
				responseVO.setCode("200");
				responseVO.setMessage(EmailLogVo+"Record (s) posted");
			}
		} catch (Exception e) {
			responseVO.setCode("404");
			responseVO.setMessage("Response not found");
			e.printStackTrace();
		}
		return responseVO;
	}
	
	@PostMapping("/updateEmailTemplateDetails")
	@ResponseBody
	public ResponseVO updateEmailTemplateDetails(@RequestBody EmailLogVo templateVO) {
		ResponseVO responseVO = new ResponseVO();
		EmailLogVo emailLogVo = null;
		try {
			String EmailLogVo1 = emailConfigurationService.updateEmailTemplateDetails(templateVO);
			if (EmailLogVo1 != null) {
				responseVO.setCode("200");
				responseVO.setMessage("Data Updated Successfully");

			} else {
				responseVO.setCode("200");
				responseVO.setMessage("Details are not updated");
			}

		} catch (Exception e) {
			responseVO.setCode("404");
			responseVO.setMessage("Response not found");
			e.printStackTrace();
		}

		return responseVO;
	}
}



