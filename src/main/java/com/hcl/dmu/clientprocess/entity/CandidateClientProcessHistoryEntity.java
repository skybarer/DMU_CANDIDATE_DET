package com.hcl.dmu.clientprocess.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="dmu_client_process_history")
public class CandidateClientProcessHistoryEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	
	@OneToOne(cascade= {CascadeType.ALL})
	private CandidateClientProcessEntity candidateClientProcessEntity;
	@Column(name="stream")
	private String stream;
	@Column(name="sub_stream")
	private String subStream;
	@Column(name="client_Interview_Date")
	private Timestamp clientInterviewDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public CandidateClientProcessEntity getClientProcessEntity() {
		return candidateClientProcessEntity;
	}
	public void setClientProcessEntity(CandidateClientProcessEntity candidateClientProcessEntity) {
		this.candidateClientProcessEntity = candidateClientProcessEntity;
	}
}
