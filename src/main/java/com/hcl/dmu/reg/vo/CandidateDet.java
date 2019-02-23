package com.hcl.dmu.reg.vo;


public class CandidateDet {
	private Long id;
	private String name;
	private Long contactNo;
	private Long alternateContactNo;
	private String emailId;
	private String primarySkill;
	private String secondarySkill;
	private String noticePeriod;
	private String servingNoticePeriod;
	private String currentCompany;
	private String hrContactPerson;
	private Long expYears;
	private Long expMonths;
	private String designation;
	private String hclPositionRole;
	private String referedBy;
	private String modeOfInterview;
	private String interviewDateTime;
	private String currentCTC;
	private String expectedCTC;
	private String status;
	private String comments;
	private String createdBy;
	private String createdDate;
	private String modifiedBy;
	private String modifiedDate;
	private ResumeUploads resumeUploads;
	private Double hackerRankScore;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getContactNo() {
		return contactNo;
	}

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

	public String getServingNoticePeriod() {
		return servingNoticePeriod;
	}

	public void setServingNoticePeriod(String servingNoticePeriod) {
		this.servingNoticePeriod = servingNoticePeriod;
	}

	public String getCurrentCompany() {
		return currentCompany;
	}

	public void setCurrentCompany(String currentCompany) {
		this.currentCompany = currentCompany;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getHclPositionRole() {
		return hclPositionRole;
	}

	public void setHclPositionRole(String hclPositionRole) {
		this.hclPositionRole = hclPositionRole;
	}

	public String getReferedBy() {
		return referedBy;
	}

	public void setReferedBy(String referedBy) {
		this.referedBy = referedBy;
	}

	public String getModeOfInterview() {
		return modeOfInterview;
	}

	public void setModeOfInterview(String modeOfInterview) {
		this.modeOfInterview = modeOfInterview;
	}

	public String getCurrentCTC() {
		return currentCTC;
	}

	public void setCurrentCTC(String cureentCTC) {
		this.currentCTC = cureentCTC;
	}

	public String getExpectedCTC() {
		return expectedCTC;
	}

	public void setExpectedCTC(String expectedCTC) {
		this.expectedCTC = expectedCTC;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getInterviewDateTime() {
		return interviewDateTime;
	}

	public void setInterviewDateTime(String interviewDateTime) {
		this.interviewDateTime = interviewDateTime;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Long getAlternateContactNo() {
		return alternateContactNo;
	}

	public void setAlternateContactNo(Long alternateContactNo) {
		this.alternateContactNo = alternateContactNo;
	}

	public String getHrContactPerson() {
		return hrContactPerson;
	}

	public void setHrContactPerson(String hrContactPerson) {
		this.hrContactPerson = hrContactPerson;
	}

	public Long getExpYears() {
		return expYears;
	}

	public void setExpYears(Long expYears) {
		this.expYears = expYears;
	}

	public Double getHackerRankScore() {
		return hackerRankScore;
	}

	public void setHackerRankScore(Double hackerRankScore) {
		this.hackerRankScore = hackerRankScore;
	}

	public Long getExpMonths() {
		return expMonths;
	}

	public void setExpMonths(Long expMonths) {
		this.expMonths = expMonths;
	}

	public String getNoticePeriod() {
		return noticePeriod;
	}

	public void setNoticePeriod(String noticePeriod) {
		this.noticePeriod = noticePeriod;
	}
	
	public ResumeUploads getResumeUploads() {
		return resumeUploads;
	}

	public void setResumeUploads(ResumeUploads resumeUploads) {
		this.resumeUploads = resumeUploads;
	}

	@Override
	public String toString() {
		return "CandidateDet [id=" + id + ", name=" + name + ", contactNo=" + contactNo + ", alternateContactNo="
				+ alternateContactNo + ", emailId=" + emailId + ", primarySkill=" + primarySkill + ", secondarySkill="
				+ secondarySkill + ", noticePeriod=" + noticePeriod + ", servingNoticePeriod=" + servingNoticePeriod
				+ ", currentCompany=" + currentCompany + ", hrContactPerson=" + hrContactPerson + ", expYears="
				+ expYears + ", expMonths=" + expMonths + ", designation=" + designation + ", hclPositionRole="
				+ hclPositionRole + ", referedBy=" + referedBy + ", modeOfInterview=" + modeOfInterview
				+ ", interviewDateTime=" + interviewDateTime + ", currentCTC=" + currentCTC + ", expectedCTC="
				+ expectedCTC + ", status=" + status + ", comments=" + comments + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate
				+ ", resumeUploads=" + resumeUploads + ", hackerRankScore=" + hackerRankScore + "]";
	}


}
