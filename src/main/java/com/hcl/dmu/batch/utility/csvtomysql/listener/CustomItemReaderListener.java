package com.hcl.dmu.batch.utility.csvtomysql.listener;

import org.springframework.batch.core.ItemReadListener;
import org.springframework.stereotype.Component;

import com.hcl.dmu.batch.utility.csvtomysql.model.CandidateDet;

@Component
public class CustomItemReaderListener implements ItemReadListener<CandidateDet> {

	@Override
	public void beforeRead() {
		System.out.println("ItemReadListener - beforeRead");
	}

	@Override
	public void afterRead(CandidateDet item) {
		System.out.println("ItemReadListener - afterRead");
	}

	@Override
	public void onReadError(Exception ex) {
		System.out.println("ItemReadListener - onReadError");
	}

}
