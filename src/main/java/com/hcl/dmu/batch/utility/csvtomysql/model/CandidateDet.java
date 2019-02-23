package com.hcl.dmu.batch.utility.csvtomysql.model;

public class CandidateDet {
	private Long id;
	private String name;
	private Long contactNo;
	private Long alternateNumber;
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
	private String hclPosition;
	private String referredBy;
	private String modeOfInterview;
	private String interviewDateTime;
	private String currentCTC;
	private String expectedCTC;
	private String status;
	private String comments;
	private Double hackerRankScore;

	public CandidateDet() {
	}

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

	public String getReferredBy() {
		return referredBy;
	}

	public void setReferredBy(String referredBy) {
		this.referredBy = referredBy;
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

	public Long getAlternateNumber() {
		return alternateNumber;
	}

	public void setAlternateNumber(Long alternateNumber) {
		this.alternateNumber = alternateNumber;
	}

	public String getHclPosition() {
		return hclPosition;
	}

	public void setHclPosition(String hclPosition) {
		this.hclPosition = hclPosition;
	}

	public String getInterviewDateTime() {
		return interviewDateTime;
	}

	public void setInterviewDateTime(String interviewDateTime) {
		this.interviewDateTime = interviewDateTime;
	}

	@Override
	public String toString() {
		return "CandidateDet [id=" + id + ", name=" + name + ", contactNo=" + contactNo + ", alternateNumber="
				+ alternateNumber + ", emailId=" + emailId + ", primarySkill=" + primarySkill + ", secondarySkill="
				+ secondarySkill + ", noticePeriod=" + noticePeriod + ", servingNoticePeriod=" + servingNoticePeriod
				+ ", currentCompany=" + currentCompany + ", hrContactPerson=" + hrContactPerson + ", expYears="
				+ expYears + ", expMonths=" + expMonths + ", designation=" + designation + ", hclPosition="
				+ hclPosition + ", referredBy=" + referredBy + ", modeOfInterview=" + modeOfInterview
				+ ", interviewDateTime=" + interviewDateTime + ", currentCTC=" + currentCTC + ", expectedCTC="
				+ expectedCTC + ", status=" + status + ", comments=" + comments + ", hackerRankScore=" + hackerRankScore
				+ "]";
	}

	public CandidateDet(String name, Long contactNo, Long alternateNumber, String emailId, String primarySkill,
			String secondarySkill, String noticePeriod, String servingNoticePeriod, String currentCompany,
			String hrContactPerson, Long expYears, Long expMonths, String designation, String hclPosition,
			String referredBy, String modeOfInterview, String interviewDateTime, String currentCTC, String expectedCTC,
			String status, String comments, Double hackerRankScore) {
		super();
		this.name = name;
		this.contactNo = contactNo;
		this.alternateNumber = alternateNumber;
		this.emailId = emailId;
		this.primarySkill = primarySkill;
		this.secondarySkill = secondarySkill;
		this.noticePeriod = noticePeriod;
		this.servingNoticePeriod = servingNoticePeriod;
		this.currentCompany = currentCompany;
		this.hrContactPerson = hrContactPerson;
		this.expYears = expYears;
		this.expMonths = expMonths;
		this.designation = designation;
		this.hclPosition = hclPosition;
		this.referredBy = referredBy;
		this.modeOfInterview = modeOfInterview;
		this.interviewDateTime = interviewDateTime;
		this.currentCTC = currentCTC;
		this.expectedCTC = expectedCTC;
		this.status = status;
		this.comments = comments;
		this.hackerRankScore = hackerRankScore;
	}
}
