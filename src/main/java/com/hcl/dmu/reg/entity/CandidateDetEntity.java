package com.hcl.dmu.reg.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.hcl.dmu.clientprocess.entity.CandidateClientProcessEntity;

@Entity
@Table(name = "dmu_candidate_details")
public class CandidateDetEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "contact_number")
	private Long contactNo;
	@Column(name = "alternate_number")
	private Long alternateContactNo;
	@Column(name = "email_id")
	private String emailId;
	@Column(name = "primary_skill")
	private String primarySkill;
	@Column(name = "secondary_skill")
	private String secondarySkill;
	@Column(name = "serving_notice_period")
	private String servingNoticePeriod;
	@Column(name = "notice_period")
	private String noticePeriod;
	@Column(name = "current_company")
	private String currentCompany;
	@Column(name = "hr_contact_person")
	private String hrContactPerson;
	@Column(name = "exp_years")
	private Long expYears;
	@Column(name = "exp_months")
	private Long expMonths;
	@Column(name = "designation")
	private String designation;
	@Column(name = "hcl_position")
	private String hclPositionRole;
	@Column(name = "referred_by")
	private String referedBy;
	@Column(name = "mode_of_interview")
	private String modeOfInterview;
	@Column(name = "interview_date_time")
	private Timestamp interviewDateTime; // leaved
	@Column(name = "current_ctc")
	private String currentCTC;
	@Column(name = "expected_ctc")
	private String expectedCTC;
	@Column(name = "status")
	private String status;
	@Column(name = "comments")
	private String comments;
	@Column(name = "createdby")
	private String createdBy;
	@Column(name = "createddate", updatable = false)
	@CreationTimestamp
	private Timestamp createdDate; // leaved
	@Column(name = "modifiedby")
	private String modifiedBy;
	@Column(name = "modifieddate")
	@UpdateTimestamp // leaved
	private Timestamp modifiedDate;
	@Column(name = "version")
	@Version
	private Long version;
	@OneToOne(mappedBy = "candidateDetEntity", cascade = { CascadeType.ALL })
	private ResumeUploadsEntity resumeUploads;
	@OneToOne(mappedBy = "candidateDetEntity", cascade = { CascadeType.ALL })
	private CandidateClientProcessEntity candidateClientProcessEntity;

	@Column(name = "hacker_rank")
	private Double hackerRankScore;

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getAlternateContactNo() {
		return alternateContactNo;
	}

	public void setAlternateContactNo(Long alternateContactNo) {
		this.alternateContactNo = alternateContactNo;
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

	public String getNoticePeriod() {
		return noticePeriod;
	}

	public void setNoticePeriod(String noticePeriod) {
		this.noticePeriod = noticePeriod;
	}

	public String getCurrentCompany() {
		return currentCompany;
	}

	public void setCurrentCompany(String currentCompany) {
		this.currentCompany = currentCompany;
	}

	public String getHrContactPerson() {
		return hrContactPerson;
	}

	public void setHrContactPerson(String hrContactPerson) {
		this.hrContactPerson = hrContactPerson;
	}

	public Double getHackerRankScore() {
		return hackerRankScore;
	}

	public void setHackerRankScore(Double hackerRankScore) {
		this.hackerRankScore = hackerRankScore;
	}

	public Long getExpYears() {
		return expYears;
	}

	public void setExpYears(Long expYears) {
		this.expYears = expYears;
	}

	public Long getExpMonths() {
		return expMonths;
	}

	public void setExpMonths(Long expMonths) {
		this.expMonths = expMonths;
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


	public Timestamp getInterviewDateTime() {
		return interviewDateTime;
	}

	public void setInterviewDateTime(Timestamp interviewDateTime) {
		this.interviewDateTime = interviewDateTime;
	}

	public String getCureentCTC() {
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

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public ResumeUploadsEntity getResumeUploads() {
		return resumeUploads;
	}

	public String getCurrentCTC() {
		return currentCTC;
	}

	public void setResumeUploads(ResumeUploadsEntity resumeUploads) {
		this.resumeUploads = resumeUploads;
	}

}
