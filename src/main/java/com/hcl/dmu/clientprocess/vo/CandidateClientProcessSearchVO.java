/**
 * 
 */
package com.hcl.dmu.clientprocess.vo;

/**
 * @author sekhar.k
 *
 */
public class CandidateClientProcessSearchVO {
	private String candidateName;
	private Long clientProcessId;
	private String mobileNo;
	private String status;
	private String stream;
	private String expFrom;
	private String expTo;
	private String dateFrom;
	private String dateTo;
	private String skill;
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public String getExpFrom() {
		return expFrom;
	}
	public void setExpFrom(String expFrom) {
		this.expFrom = expFrom;
	}
	public String getExpTo() {
		return expTo;
	}
	public void setExpTo(String expTo) {
		this.expTo = expTo;
	}
	public String getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}
	public String getDateTo() {
		return dateTo;
	}
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public Long getClientProcessId() {
		return clientProcessId;
	}
	public void setClientProcessId(Long clientProcessId) {
		this.clientProcessId = clientProcessId;
	}
	
	
	

}
