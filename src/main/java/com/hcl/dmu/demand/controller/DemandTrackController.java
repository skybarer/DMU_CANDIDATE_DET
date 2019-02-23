package com.hcl.dmu.demand.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hcl.dmu.demand.service.DemandTrackService;
import com.hcl.dmu.demand.vo.DemandDetailsVo;
import com.hcl.dmu.demand.vo.SkillStreamDetails;
import com.hcl.dmu.reg.vo.ResponseVO;

@Controller
public class DemandTrackController {

	private static final Logger log = LoggerFactory.getLogger(DemandTrackController.class);

	@Autowired
	private DemandTrackService demandTrackService;

	@GetMapping("/getskillDemandDetails")
	public @ResponseBody ResponseVO getDemandDetails() {
		SkillStreamDetails skillDemandDetails = null;
		ResponseVO responseVO = new ResponseVO();
		try {
			skillDemandDetails = demandTrackService.getSkillDemandDetails();

			if (skillDemandDetails != null) {
				responseVO.setCode("200");
				responseVO.setMessage(skillDemandDetails);

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

	@PostMapping("/addDemandDetails")
	public @ResponseBody ResponseVO addDemandDetails(@RequestBody DemandDetailsVo demandDetailsVo) {
		ResponseVO responseVO = null;
		String[] tokens = null;
		try {
			responseVO = new ResponseVO();
			String response = demandTrackService.insertDemandTrackerService(demandDetailsVo);
			tokens = response.split("~");
			if (!response.isEmpty() && "success".equals(tokens[0])) {
				responseVO.setMessage("Record (s) inserted successfully ");
				responseVO.setCode(tokens[1]);
			} else {
				responseVO.setMessage("Exception Occured");
				responseVO.setCode("");
			}

		} catch (Exception e) {
			log.info(e.getMessage());
			responseVO.setCode("404");
			responseVO.setMessage("Response not found");
			e.printStackTrace();
		}

		return responseVO;

	}

	@PostMapping("/updateDemandDetails")
	public @ResponseBody ResponseVO updateDemandDetails(@RequestBody DemandDetailsVo demandDetailsVo) {
		ResponseVO responseVO = null;
		String[] tokens = null;
		try {
			responseVO = new ResponseVO();
			String response = demandTrackService.updateDemandTrackerDetails(demandDetailsVo);
			tokens = response.split("~");
			if (!response.isEmpty() && "success".equals(tokens[0])) {
				responseVO.setMessage("Record updated successfully ");
				responseVO.setCode(tokens[1]);
			} else {
				responseVO.setMessage("Exception Occured");
				responseVO.setCode("");
			}

		} catch (Exception e) {
			log.info(e.getMessage());
			responseVO.setCode("404");
			responseVO.setMessage("Response not found");
			e.printStackTrace();
		}

		return responseVO;

	}

	@GetMapping("/getDemandTrackerDetails")
	public @ResponseBody ResponseVO getDemandTrackerDetails() {

		List<DemandDetailsVo> demandDetailsVos = null;
		ResponseVO responseVO = new ResponseVO();
		try {
			demandDetailsVos = demandTrackService.getAllDemandTrackerEntities();

			if (demandDetailsVos != null) {
				responseVO.setCode("200");
				responseVO.setMessage(demandDetailsVos);

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

	@GetMapping("/searchDemandTrackerDetails")
	public @ResponseBody ResponseVO searchDemandTrackerDetails(@RequestParam("skillName") String skillName,
			@RequestParam("streamName") String streamName, @RequestParam("subStreamName") String subStreamName) {

		List<DemandDetailsVo> demandDetailsVos = null;
		ResponseVO responseVO = new ResponseVO();
		try {
			demandDetailsVos = demandTrackService.searchDemandTrackerEntities(skillName, streamName,subStreamName );

			if (demandDetailsVos != null) {
				responseVO.setCode("200");
				responseVO.setMessage(demandDetailsVos);

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
