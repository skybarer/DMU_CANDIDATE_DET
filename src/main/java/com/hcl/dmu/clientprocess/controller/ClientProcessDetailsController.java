package com.hcl.dmu.clientprocess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hcl.dmu.clientprocess.entity.CandidateClientProcessEntity;
import com.hcl.dmu.clientprocess.service.ClientProcessDetailsService;
import com.hcl.dmu.clientprocess.vo.CandidateClientProcessSearchVO;
import com.hcl.dmu.clientprocess.vo.CandidateClientProcessVo;
import com.hcl.dmu.config.EmailService;
import com.hcl.dmu.reg.entity.CandidateDetEntity;
import com.hcl.dmu.reg.vo.ResponseVO;
import com.hcl.dmu.utils.RecordCountUtility;

@Controller
public class ClientProcessDetailsController {

	@Autowired
	private ClientProcessDetailsService clientProcessDetailsService;
	
	@Autowired
	private RecordCountUtility recordCountUtility;
	
	@PostMapping("/insertClientProcessDetails")
	@ResponseBody
	public ResponseVO insertClientProcessDetails(@RequestBody List<Long> ids) {
		ResponseVO responseVO = new ResponseVO();
		try {
			int noOfRecs = clientProcessDetailsService.insertClientProcessDetails(ids);
			
			if(noOfRecs>0) {
				responseVO.setCode("200");
				responseVO.setMessage(noOfRecs+"Record (s) posted successfully");
			}else {
				responseVO.setCode("200");
				responseVO.setMessage(noOfRecs+"Record (s) posted");
			}
		} catch (Exception e) {
			responseVO.setCode("404");
			responseVO.setMessage("Response not found");
			e.printStackTrace();
		}
		return responseVO;
	}
	
	@GetMapping("/allClientProcessDetails")
	@ResponseBody
	public ResponseVO getAllClientProcessDetails(@RequestParam("pagenum") long pagenum) {
		ResponseVO responseVO = new ResponseVO();
		List<CandidateClientProcessVo> candidateClientProcessVoList = null;
		try {
			candidateClientProcessVoList = clientProcessDetailsService.getAllClientProcessDetails(pagenum);
			if (candidateClientProcessVoList != null && !candidateClientProcessVoList.isEmpty()) {
				responseVO.setCode("200");
				responseVO.setMessage(candidateClientProcessVoList);
				responseVO.setRecordCount(recordCountUtility.getRecordCount(CandidateClientProcessEntity.class.newInstance()));

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
	
	
	@PostMapping("/searchClientProcessDetails")
	@ResponseBody
	public ResponseVO searchClientProcessDetails(@RequestBody CandidateClientProcessSearchVO searchVO) {
		ResponseVO responseVO = new ResponseVO();
		List<CandidateClientProcessVo> candidateClientProcessVoList = null;
		try {
			candidateClientProcessVoList = clientProcessDetailsService.searchClientProcessDetails(searchVO);
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
	
	@PostMapping("/editClientProcessDetails")
	@ResponseBody
	public ResponseVO editClientProcessDetails(@RequestParam("clientProcessID")Long clientProcessID) {
		ResponseVO responseVO = new ResponseVO();
		CandidateClientProcessVo candidateClientProcessVoList = null;
		try {
			candidateClientProcessVoList = clientProcessDetailsService.getClientProcessDetailsByID(clientProcessID);
			if (candidateClientProcessVoList != null) {
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
	
	
	@PostMapping("/updateClientProcessDetails")
	@ResponseBody
	public ResponseVO updateClientProcessDetails(@RequestBody CandidateClientProcessVo searchVO) {
		ResponseVO responseVO = new ResponseVO();
		int candidateClientProcessVoList =0;
		try {
			candidateClientProcessVoList = clientProcessDetailsService.updateClientProcessDetails(searchVO);
			if (candidateClientProcessVoList > 0) {
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
