package com.hcl.dmu.batch.utility.csvtomysql.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.hcl.dmu.batch.utility.csvtomysql.model.CandidateDet;


public class CandidateDetItemProcessor implements ItemProcessor<CandidateDet, CandidateDet> {

	private static final Logger LOG = LoggerFactory.getLogger(CandidateDetItemProcessor.class);

	@Override
	public CandidateDet process(CandidateDet candidateDet) throws Exception {
		
		return candidateDet;
	}
}