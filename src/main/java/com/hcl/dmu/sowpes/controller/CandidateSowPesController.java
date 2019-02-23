package com.hcl.dmu.sowpes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hcl.dmu.clientprocess.vo.CandidateClientProcessVo;
import com.hcl.dmu.reg.vo.ResponseVO;
import com.hcl.dmu.sowpes.service.CandidateSowPesService;
import com.hcl.dmu.sowpes.vo.CandidateSowPesVo;

@Controller
public class CandidateSowPesController {

	@Autowired
	private CandidateSowPesService candidateSowPesService;

	@GetMapping("/allClientSelectedDetails")
	public @ResponseBody ResponseVO getAllClientSelectedDetails() {
		ResponseVO responseVO = new ResponseVO();
		List<CandidateClientProcessVo> candidateClientProcessVoList = null;
		try {
			candidateClientProcessVoList = candidateSowPesService.getAllClientSelectedDetails();
			if (candidateClientProcessVoList != null && !candidateClientProcessVoList.isEmpty()) {
				responseVO.setCode("200");
				responseVO.setMessage(candidateClientProcessVoList);
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

	@PostMapping("/insertSelectedCandidateDetails")
	public @ResponseBody ResponseVO insertSelectedCandidateDetails(
			@RequestBody List<CandidateSowPesVo> candidateSowPesVoList) {
		ResponseVO responseVO = new ResponseVO();
		try {
			int noOfRecs = candidateSowPesService.insertSelectedCandidateDetails(candidateSowPesVoList);

			if (noOfRecs > 0) {
				responseVO.setCode("200");
				responseVO.setMessage(noOfRecs + "Record (s) posted successfully");
			} else {
				responseVO.setCode("200");
				responseVO.setMessage(noOfRecs + "Record (s) posted");
			}
		} catch (Exception e) {
			responseVO.setCode("404");
			responseVO.setMessage("Response not found");
			e.printStackTrace();
		}
		return responseVO;
	}

	@GetMapping("/getCandidateSowPesDetails")
	public @ResponseBody ResponseVO getCandidateSowPesDetails() {
		ResponseVO responseVO = new ResponseVO();
		List<CandidateSowPesVo> candidateSowPesVoList = null;
		try {
			candidateSowPesVoList = candidateSowPesService.getCandidateSowPesDetails();
			if (!candidateSowPesVoList.isEmpty()) {
				responseVO.setCode("200");
				responseVO.setMessage(candidateSowPesVoList);
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

	@PostMapping("/updateCandidateSowPesDetails")
	public @ResponseBody ResponseVO updateCandidateSowPesDetails(
			@RequestBody List<CandidateSowPesVo> candidateSowPesVoList) {
		ResponseVO responseVO = new ResponseVO();
		try {
			int noOfRecs = candidateSowPesService.updateCandidateSowPesDetails(candidateSowPesVoList);

			if (noOfRecs > 0) {
				responseVO.setCode("200");
				responseVO.setMessage(noOfRecs + "Record (s) updated successfully");
			} else {
				responseVO.setCode("200");
				responseVO.setMessage(noOfRecs + "Record (s) updated");
			}
		} catch (Exception e) {
			responseVO.setCode("404");
			responseVO.setMessage("Response not found");
			e.printStackTrace();
		}
		return responseVO;
	}
}
