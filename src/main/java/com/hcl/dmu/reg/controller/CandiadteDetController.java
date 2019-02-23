package com.hcl.dmu.reg.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.dmu.config.EmailService;
import com.hcl.dmu.email.vo.EmailLogVo;
import com.hcl.dmu.reg.entity.CandidateDetEntity;
import com.hcl.dmu.reg.service.CandaidateDetService;
import com.hcl.dmu.reg.service.ProfileService;
import com.hcl.dmu.reg.vo.CandidateDet;
import com.hcl.dmu.reg.vo.ProfileSummaryVo;
import com.hcl.dmu.reg.vo.ResponseVO;
import com.hcl.dmu.utils.RecordCountUtility;

@Controller
@CrossOrigin(allowedHeaders={"*"})
public class CandiadteDetController {

	private static final Logger log = LoggerFactory.getLogger(CandiadteDetController.class);

	@Value("${filePath}")
	private String filePath;
	
	@Value("${uploadProfilePath}")
	private String uploadProfilePath;
	

	@Autowired
	private CandaidateDetService candidateDetService;

	@Autowired
	private ProfileService profileService;

	@Autowired
	private ObjectMapper mapper;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private RecordCountUtility recordCountUtility;

	@PostMapping(value = "/insertCandidateDetails")
	@ResponseBody
	public ResponseVO insertCandidateDetails(@RequestParam(value = "candidate") String candidateDetJSON,
			@RequestParam(value = "file", required = false) MultipartFile file) {

		ResponseVO responseVO = null;
		String[] tokens = null;
		try {
			CandidateDet candidateDet = mapper.readValue(candidateDetJSON, CandidateDet.class);
			responseVO = new ResponseVO();
			String response = candidateDetService.insertCandidateDetails(candidateDet, file);
			tokens = response.split("~");
			if (!response.isEmpty() && "success".equals(tokens[0]) && file == null) {
				responseVO.setMessage("Record (s) inserted successfully but resume was not uploaded");
				responseVO.setCode(tokens[1]);
			} else if (!response.isEmpty() && "success".equals(tokens[0])) {
				responseVO.setMessage("Record (s) inserted successfully");
				responseVO.setCode(tokens[1]);
			} else {
				responseVO.setMessage("Exception Occured");
				responseVO.setCode("");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseVO;
	}

	@GetMapping(value = "/allCandidateDetails")
	@ResponseBody
	public ResponseVO getAllCandidateDetails(@RequestParam("pagenum") long pagenum) {
		ResponseVO responseVO = new ResponseVO();
		List<CandidateDet> candidateDetList = null;
		try {
			candidateDetList = candidateDetService.getAllCandidateDetails(pagenum);
			if (candidateDetList != null && !candidateDetList.isEmpty()) {
				responseVO.setCode("200");
				responseVO.setMessage(candidateDetList);
				responseVO.setRecordCount(recordCountUtility.getRecordCount(CandidateDetEntity.class.newInstance()));


			} else {
				responseVO.setCode("200");
				responseVO.setMessage("Details are empty");
			}

		} catch (Exception e) {
			responseVO.setCode("404");
			responseVO.setMessage("Response not found");
			e.printStackTrace();
		}
		log.info(responseVO.toString());
		return responseVO;
	}

	@GetMapping("/download")
	public void downloadFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			File file = new File(getClass().getClassLoader().getResource(filePath).getFile());
			if (file.exists()) {

				// get the mimetype
				String mimeType = URLConnection.guessContentTypeFromName(file.getName());
				if (mimeType == null) {
					// unknown mimetype so set the mimetype to application/octet-stream
					mimeType = "application/octet-stream";
				}

				response.setContentType(mimeType);


				response.setHeader("Content-Disposition",
						String.format("attachment; filename=\"" + file.getName() + "\""));
				response.setContentLength((int) file.length());
				InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
				FileCopyUtils.copy(inputStream, response.getOutputStream());
			}

		} catch (IOException e) {

			log.error(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	@PostMapping(value = "/modifyCandidateDetails")
	@ResponseBody
	public ResponseVO modifyCandidateDetails(@RequestParam(value = "candidate") String candidateDetJSON,
			@RequestParam(value = "file", required = false) MultipartFile file) {
		System.out.println(candidateDetJSON.toString());
		ResponseVO responseVO = null;
		String[] tokens = null;
		try {
			responseVO = new ResponseVO();
			CandidateDet candidateDet = mapper.readValue(candidateDetJSON, CandidateDet.class);
			String response = candidateDetService.modifyCandidateDetails(candidateDet, file);
			tokens = response.split("~");
			if (!response.isEmpty() && "success".equals(tokens[0]) && file == null) {
				responseVO.setMessage("Record (s) inserted successfully but resume was not uploaded");
				responseVO.setCode(tokens[1]);
			} else if (!response.isEmpty() && "success".equals(tokens[0])) {
				responseVO.setMessage("Record (s) inserted successfully");
				responseVO.setCode(tokens[1]);
			} else {
				responseVO.setMessage("Exception Occured");
				responseVO.setCode("");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseVO;
	}

	@PostMapping(value = "/uploadProfile")
	@ResponseBody
	public ResponseVO uploadProfile(@RequestParam("candidate_id") Long id,
			@RequestParam(value = "file") MultipartFile file) {

		ResponseVO responseVO = null;
		String[] tokens = null;
		CandidateDetEntity candidate = candidateDetService.findByCandidate(id);
		try {
			responseVO = new ResponseVO();
			String response = profileService.uploadProfile(candidate, file);
			tokens = response.split("~");
			if (!response.isEmpty() && "success".equals(tokens[0]) && file == null) {
				responseVO.setMessage("Record (s) inserted successfully but resume was not uploaded");
				responseVO.setCode(tokens[1]);
			} else if (!response.isEmpty() && "success".equals(tokens[0])) {
				responseVO.setMessage("Record (s) inserted successfully");
				responseVO.setCode(tokens[1]);
			} else {
				responseVO.setMessage("Exception Occured");
				responseVO.setCode("");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseVO;
	}
	
	@PostMapping("/initiateHackerRank")
	@ResponseBody
	public ResponseVO initiateHackerRank(@RequestBody List<Long> ids) {
		ResponseVO responseVO = new ResponseVO();
		try {
			int noOfRecs = candidateDetService.initiateHackerRank(ids);
			
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
	
	@PostMapping(value = "/insertProfileSummaryDetails")
	@ResponseBody
	public ResponseVO insertProfileSummaryDetails(@RequestParam(value = "profile") String profile,
			@RequestParam(value = "photo", required = false) MultipartFile photo) {

		ResponseVO responseVO = null;
		try {
			ProfileSummaryVo profileSummaryVo = mapper.readValue(profile, ProfileSummaryVo.class);
			responseVO = new ResponseVO();
			String response = candidateDetService.insertProfileSummaryDetails(profileSummaryVo,photo);
			if (!response.isEmpty()) {
				
				responseVO.setMessage("Record (s) inserted/updated successfully");
				responseVO.setCode("200");
			} else {
				responseVO.setMessage("Exception Occured");
				responseVO.setCode("500");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseVO;
	}
	
	@GetMapping(value = "/profileDetails")
	@ResponseBody
	public ResponseVO getProfileDetails(@RequestParam("id") Long id) {
		ResponseVO responseVO = new ResponseVO();
		ProfileSummaryVo profileSummaryVo = null;
		try {
			profileSummaryVo = candidateDetService.getProfileDetails(id);
			if (profileSummaryVo != null) {
				responseVO.setCode("200");
				responseVO.setMessage(profileSummaryVo);
			} else {
				responseVO.setCode("200");
				responseVO.setMessage("Details are empty");
			}
		} catch (Exception e) {
			responseVO.setCode("404");
			responseVO.setMessage("Response not found");
			e.printStackTrace();
		}
		log.info(responseVO.toString());
		return responseVO;
	}
	
	@GetMapping(value = "/image",produces = "image/jpg")
	public @ResponseBody byte[] getFile(@RequestParam("image") String image)  {
	    try {
	        // Retrieve image from the classpath.
	    	File file = new File(uploadProfilePath+image);

	        // Prepare buffered image.
	        BufferedImage img = ImageIO.read(file);

	        ByteArrayOutputStream bao = new ByteArrayOutputStream();

	        // Write to output stream
	        ImageIO.write(img, "jpg", bao);

	        return bao.toByteArray();
	    } catch (IOException e) {
	    	log.error(e.getMessage());
	        e.printStackTrace();
	    }
	    return new byte[0];
	}
	
	@GetMapping(value = "/candidate-details-count")
	@ResponseBody
	public ResponseVO getCandidateDetailsCount() {
		ResponseVO responseVO = new ResponseVO();
		Long noOfRecords = null;
		try {
			noOfRecords = candidateDetService.getCandidateDetailsCount();
			responseVO.setCode("200");
			responseVO.setMessage(noOfRecords);
		} catch (Exception e) {
			responseVO.setCode("404");
			responseVO.setMessage("Response not found");
			e.printStackTrace();
		}
		log.info(responseVO.toString());
		return responseVO;
	}
	
	@GetMapping(value = "/send-email")
	@ResponseBody
	public ResponseVO sendEmail(@RequestParam("emails") List<String> emails) {
		ResponseVO responseVO = new ResponseVO();
		try {
			for (String email : emails) {
				emailService.sendSimpleMessage("sekhar.k@hcl.com",email, "Your are shortlisted for Interview", "Please get ready for interview",null,null);
			}
			responseVO.setCode("200");
			responseVO.setMessage("Email Sent Successfully");
		} catch (Exception e) {
			responseVO.setCode("404");
			responseVO.setMessage("Response not found");
			e.printStackTrace();
		}
		log.info(responseVO.toString());
		return responseVO;
	}
	
	@PostMapping(value = "/email-candidates")
	@ResponseBody
	public ResponseVO sendEmailForCandidates(@RequestBody EmailLogVo emailLogVo) {
		ResponseVO responseVO = new ResponseVO();
		try {
			emailService.sendSimpleMessage(emailLogVo.getFrom(),emailLogVo.getTo(), emailLogVo.getSubject(), emailLogVo.getMessage(),emailLogVo.getBcc(),emailLogVo.getCc());
			responseVO.setCode("200");
			responseVO.setMessage("Email(s) Sent Successfully");
		} catch (Exception e) {
			responseVO.setCode("404");
			responseVO.setMessage("Response not found");
			e.printStackTrace();
		}
		log.info(responseVO.toString());
		return responseVO;
	}
}
