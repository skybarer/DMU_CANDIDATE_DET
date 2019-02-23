package com.hcl.dmu.clientprocess.vo;

public class CandidateClientProcessVo {
	
	private Long id;
	private Long clientProcessId;
	private String candidateName;
	private String mobileNo;
	private String expFrom;
	private String expTo;
	private String status;
	private String stream;
	private String dateFrom;
	private String dateTo;
	private String primarySkill;
	private String secondarySkill;
	private String clientInterviewDate;
	private String clientInterviewTime;
	private String expYrs;
	private String expMonths;
	private String contactPerson;
	private String subStream;

	public String getSubStream() {
		return subStream;
	}
	public void setSubStream(String subStream) {
		this.subStream = subStream;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	
	public String getClientInterviewDate() {
		return clientInterviewDate;
	}
	public void setClientInterviewDate(String clientInterviewDate) {
		this.clientInterviewDate = clientInterviewDate;
	}
	public String getExpYrs() {
		return expYrs;
	}
	public void setExpYrs(String expYrs) {
		this.expYrs = expYrs;
	}
	public String getExpMonths() {
		return expMonths;
	}
	public void setExpMonths(String expMonths) {
		this.expMonths = expMonths;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public Long getClientProcessId() {
		return clientProcessId;
	}
	public void setClientProcessId(Long clientProcessId) {
		this.clientProcessId = clientProcessId;
	}
	public String getPrimarySkill() {
		return primarySkill;
	}
	public void setPrimarySkill(String primarySkill) {
		this.primarySkill = primarySkill;
	}
	public String getSecondarySkill() {
		return secondarySkill;
	}
	public void setSecondarySkill(String secondarySkill) {
		this.secondarySkill = secondarySkill;
	}
	public String getClientInterviewTime() {
		return clientInterviewTime;
	}
	public void setClientInterviewTime(String clientInterviewTime) {
		this.clientInterviewTime = clientInterviewTime;
	}
	@Override
	public String toString() {
		return "CandidateClientProcessVo [id=" + id + ", clientProcessId=" + clientProcessId + ", candidateName="
				+ candidateName + ", mobileNo=" + mobileNo + ", expFrom=" + expFrom + ", expTo=" + expTo + ", status="
				+ status + ", stream=" + stream + ", dateFrom=" + dateFrom + ", dateTo=" + dateTo + ", primarySkill="
				+ primarySkill + ", secondarySkill=" + secondarySkill + ", clientInterviewDate=" + clientInterviewDate
				+ ", clientInterviewTime=" + clientInterviewTime + ", expYrs=" + expYrs + ", expMonths=" + expMonths
				+ ", contactPerson=" + contactPerson + ", subStream=" + subStream + "]";
	}
	
}
