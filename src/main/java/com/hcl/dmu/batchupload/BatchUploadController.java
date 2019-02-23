package com.hcl.dmu.batchupload;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hcl.dmu.batch.service.BatchService;
import com.hcl.dmu.reg.vo.ResponseVO;
import com.hcl.dmu.utils.BatchUtils;


@Controller
public class BatchUploadController {
	
	@Value("${batchProfilePath}")
	private String batchProfilePath;
	
	@Autowired
	private BatchService service;

	@Autowired
	private BatchUtils batchUtils;
	
	@PostMapping(value = "/uploadBatchProfile")
		@ResponseBody
		public ResponseVO uploadProfile(@RequestParam(value = "file") MultipartFile file ) {
	
			ResponseVO responseVO = null;
			String batchFileName = batchUtils.getUploadedFilePath("batch", file);
			String response = service.saveFilePath(batchFileName);
			responseVO = new ResponseVO();
			if(!StringUtils.isEmpty(batchFileName) && !StringUtils.isEmpty(response)){
				responseVO.setCode("200");
				responseVO.setMessage("Successfully uploaded");
			}else{
				responseVO.setCode("500");
				responseVO.setMessage("file not uploaded");
			}
			return responseVO;
		}
	
	@GetMapping(value = "/getBatchPath")
	@ResponseBody
	public ResponseVO getFilePath(){
		
		ResponseVO responseVO = null;
		//String batchFileName = batchUtils.getUploadedFilePath("batch", file);
		String response = service.getFilePath();
		responseVO = new ResponseVO();
		if(!StringUtils.isEmpty(response)){
			responseVO.setCode("200");
			responseVO.setMessage(response);
		}else{
			responseVO.setCode("500");
			responseVO.setMessage("file not uploaded");
		}
		return responseVO;
	}
}

