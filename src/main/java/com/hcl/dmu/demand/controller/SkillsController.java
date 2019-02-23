package com.hcl.dmu.demand.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hcl.dmu.demand.service.SkillService;
import com.hcl.dmu.demand.vo.PrimarySkillVo;
import com.hcl.dmu.demand.vo.SecondarySkillVo;
import com.hcl.dmu.reg.vo.ResponseVO;

@Controller
public class SkillsController {
	
	private static final Logger log = LoggerFactory.getLogger(SkillsController.class);

	@Autowired
	private SkillService skillsService;

	@GetMapping("/primarySkills")
	public @ResponseBody ResponseVO getPrimarySkills() {
		List<PrimarySkillVo> primarySkillVos = null;
		ResponseVO responseVO = new ResponseVO();
		try {
			primarySkillVos = skillsService.getPrimarySkills();

			if (primarySkillVos != null) {
				responseVO.setCode("200");
				responseVO.setMessage(primarySkillVos);

			} else {
				responseVO.setCode("200");
				responseVO.setMessage("Details are empty");
			}
		} catch (Exception e) {
			responseVO.setCode("404");
			responseVO.setMessage("Response not found");

			log.error(e.getMessage());
			e.printStackTrace();
		}

		return responseVO;
	}
	
	@GetMapping("/secondarySkills")
	public @ResponseBody ResponseVO getSecondarySkills(@RequestParam("skillName") String skillName) {
		List<SecondarySkillVo> secondarySkillVos = null;
		ResponseVO responseVO = new ResponseVO();
		try {
			secondarySkillVos = skillsService.getSecondarySkills(skillName);

			if (secondarySkillVos != null) {
				responseVO.setCode("200");
				responseVO.setMessage(secondarySkillVos);

			} else {
				responseVO.setCode("200");
				responseVO.setMessage("Details are empty");
			}
		} catch (Exception e) {
			responseVO.setCode("404");
			responseVO.setMessage("Response not found");

			log.error(e.getMessage());
			e.printStackTrace();
		}

		return responseVO;
	}
}
