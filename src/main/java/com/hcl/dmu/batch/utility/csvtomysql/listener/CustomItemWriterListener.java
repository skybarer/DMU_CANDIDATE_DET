package com.hcl.dmu.batch.utility.csvtomysql.listener;

import java.util.List;

import org.springframework.batch.core.ItemWriteListener;
import org.springframework.stereotype.Component;

import com.hcl.dmu.batch.utility.csvtomysql.model.CandidateDet;

@Component
public class CustomItemWriterListener implements ItemWriteListener<CandidateDet> {

	@Override
	public void beforeWrite(List<? extends CandidateDet> items) {
		System.out.println("ItemWriteListener - beforeWrite");
	}

	@Override
	public void afterWrite(List<? extends CandidateDet> items) {
		System.out.println("ItemWriteListener - afterWrite");
	}

	@Override
	public void onWriteError(Exception exception, List<? extends CandidateDet> items) {
		System.out.println("ItemWriteListener - onWriteError");
	}

}