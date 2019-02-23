package com.hcl.dmu.batch.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dmu.batch.dao.BatchDao;

@Service
@Transactional
public class BatchServiceImpl implements BatchService {
	
	@Autowired
	private BatchDao dao;

	@Override
	public String saveFilePath(String filePath) {
		return dao.saveFilePath(filePath);
	}

	@Override
	public String getFilePath(){
		return dao.getFilePath();
	}
}
