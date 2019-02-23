package com.hcl.dmu.clientprocess.vo;

import java.sql.Timestamp;

public class CandidateClientProcessHistoryVo {
	
	private Long serialNo;
	private Long clientProcessSerialNo;
	private String stream;
	private String subStream;
	private Timestamp clientInterviewDate;

	
	public Long getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(Long serialNo) {
		this.serialNo = serialNo;
	}
	public Long getClientProcessSerialNo() {
		return clientProcessSerialNo;
	}
	public void setClientProcessSerialNo(Long clientProcessSerialNo) {
		this.clientProcessSerialNo = clientProcessSerialNo;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public String getSubStream() {
		return subStream;
	}
	public void setSubStream(String subStream) {
		this.subStream = subStream;
	}
	public Timestamp getClientInterviewDate() {
		return clientInterviewDate;
	}
	public void setClientInterviewDate(Timestamp clientInterviewDate) {
		this.clientInterviewDate = clientInterviewDate;
	}
	
	
	@Override
	public String toString() {
		return "CandidateClientProcessHistoryVo [serialNo=" + serialNo + ", clientProcessSerialNo="
				+ clientProcessSerialNo + ", stream=" + stream + ", subStream=" + subStream + ", clientInterviewDate="
				+ clientInterviewDate + "]";
	}
	
	
	

}
