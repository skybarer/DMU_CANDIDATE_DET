package com.hcl.dmu.clientprocess.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.hcl.dmu.reg.entity.CandidateDetEntity;

@Entity
@Table(name="dmu_client_process_details")
public class CandidateClientProcessEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="candidate_id",nullable=false)
	private CandidateDetEntity candidateDetEntity;
	
	@Column(name = "name")
	private String candidateName;
	
	@Column(name="experience_yrs")
	private Long expYrs;
	
	@Column(name="experience_months")
	private Long expMonths;
	
	@Column(name="stream")
	private String stream;
	
	@Column(name="sub_stream")
	private String subStream;
	
	@Column(name="contact_person")
	private String contactPerson;
	
	@Column(name="contact_number")
	private Long contactNumber;
	
	@Column(name="status")
	private String status;
	
	@CreationTimestamp
	@Column(name="created_date",updatable=false)
	private Timestamp createdDate;
	
	@Column(name="created_by")
	private String createdBy;
	
	@UpdateTimestamp
	@Column(name="modified_date")
	private Timestamp modifiedDate;
	
	@Column(name="modified_by")
	private String modifiedBy;
	
	@Column(name="mobile_no")
	private Long mobileNo;
	
	@Column(name="primary_skill")
	private String primarySkill;
	
	@Column(name="secondary_skill")
	private String secondarySkill;
	
	@Column(name="client_interview_date")
	private Timestamp clientInterviewDate;
	
	@Column(name="client_interview_time")
	private String clientInterviewTime;
	
	@OneToOne(mappedBy="candidateClientProcessEntity",cascade= {CascadeType.ALL})
	private CandidateClientProcessHistoryEntity candidateClientProcessHistoryEntity;
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public CandidateDetEntity getCandidateDetEntity() {
		return candidateDetEntity;
	}



	public void setCandidateDetEntity(CandidateDetEntity candidateDetEntity) {
		this.candidateDetEntity = candidateDetEntity;
	}



	public String getCandidateName() {
		return candidateName;
	}



	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
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
	public String getContactPerson() {
		return contactPerson;
	}



	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}



	public Long getContactNumber() {
		return contactNumber;
	}



	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	


	public Timestamp getCreatedDate() {
		return createdDate;
	}



	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}



	public String getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}



	public Timestamp getModifiedDate() {
		return modifiedDate;
	}



	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}



	public String getModifiedBy() {
		return modifiedBy;
	}



	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}



	public Long getMobileNo() {
		return mobileNo;
	}



	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}


	public Timestamp getClientInterviewDate() {
		return clientInterviewDate;
	}



	public void setClientInterviewDate(Timestamp clientInterviewDate) {
		this.clientInterviewDate = clientInterviewDate;
	}

	public CandidateClientProcessHistoryEntity getCandidateClientProcessHistoryEntity() {
		return candidateClientProcessHistoryEntity;
	}


	public void setCandidateClientProcessHistoryEntity(
			CandidateClientProcessHistoryEntity candidateClientProcessHistoryEntity) {
		this.candidateClientProcessHistoryEntity = candidateClientProcessHistoryEntity;
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



	public Long getExpYrs() {
		return expYrs;
	}



	public void setExpYrs(Long expYrs) {
		this.expYrs = expYrs;
	}



	public Long getExpMonths() {
		return expMonths;
	}



	public void setExpMonths(Long expMonths) {
		this.expMonths = expMonths;
	}



	public String getClientInterviewTime() {
		return clientInterviewTime;
	}



	public void setClientInterviewTime(String clientInterviewTime) {
		this.clientInterviewTime = clientInterviewTime;
	}



	@Override
	public String toString() {
		return "CandidateClientProcessEntity [id=" + id + ", candidateDetEntity=" + candidateDetEntity
				+ ", candidateName=" + candidateName + ", expYrs=" + expYrs + ", expMonths=" + expMonths + ", stream="
				+ stream + ", subStream=" + subStream + ", contactPerson=" + contactPerson + ", contactNumber="
				+ contactNumber + ", status=" + status + ", createdDate=" + createdDate + ", createdBy=" + createdBy
				+ ", modifiedDate=" + modifiedDate + ", modifiedBy=" + modifiedBy + ", mobileNo=" + mobileNo
				+ ", primarySkill=" + primarySkill + ", secondarySkill=" + secondarySkill + ", clientInterviewDate="
				+ clientInterviewDate + ", clientInterviewTime=" + clientInterviewTime
				+ ", candidateClientProcessHistoryEntity=" + candidateClientProcessHistoryEntity + "]";
	}

}
