package com.hcl.dmu.clientprocess.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hcl.dmu.clientprocess.service.StreamService;
import com.hcl.dmu.clientprocess.vo.StreamEntityVo;
import com.hcl.dmu.clientprocess.vo.SubStreamEntityVo;

@Controller
public class StreamController {

	private static final Logger log = LoggerFactory.getLogger(StreamController.class);

	@Autowired
	private StreamService streamService;

	
	@GetMapping("/getAllStreamDetails")
	@ResponseBody
	public List<StreamEntityVo> getAllStreamDetails() {
		List<StreamEntityVo> allStreamDetails = null;
		try {
			allStreamDetails = streamService.getAllStreamDetails();
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("controller"+allStreamDetails);
		return allStreamDetails;
	}
	
	@GetMapping("/getAllSubStreamDetails")
	@ResponseBody
	public List<SubStreamEntityVo> getAllSubStreamDetails(@RequestParam("streamName") String streamName) {
		List<SubStreamEntityVo> allStreamDetails = null;
		try {
			allStreamDetails = streamService.getAllSubStreamDetails(streamName);
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("controller"+allStreamDetails);
		return allStreamDetails;
	}

}
