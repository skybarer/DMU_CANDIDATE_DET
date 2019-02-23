package com.hcl.dmu.clientprocess.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dmu.clientprocess.dao.StreamDao;
import com.hcl.dmu.clientprocess.vo.StreamEntityVo;
import com.hcl.dmu.clientprocess.vo.SubStreamEntityVo;

@Service
@Transactional
public class StreamServiceImpl implements StreamService{
	
	private static final Logger log = LoggerFactory.getLogger(StreamServiceImpl.class);

	
	@Autowired
	private StreamDao streamDao; 

	@Override
	public List<StreamEntityVo> getAllStreamDetails() {
		List<StreamEntityVo> allStreamDetails = null;
		try {
			allStreamDetails = streamDao.getAllStreamDetails();
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		
				System.out.println("service"+allStreamDetails);

		return allStreamDetails;
	}

	@Override
	public List<SubStreamEntityVo> getAllSubStreamDetails(String streamName) {
		List<SubStreamEntityVo> allStreamDetails = null;
		try {
			allStreamDetails = streamDao.getAllSubStreamDetails(streamName);
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
				System.out.println("service"+allStreamDetails);

		return allStreamDetails;
	}
	
	

}
