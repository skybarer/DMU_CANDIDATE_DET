package com.hcl.dmu.sowpes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dmu_sow_pes_details")
public class CandidateSowPesEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name="sow_no")
	private String sowNo;
	@Column(name="status")
	private String status;
	@Column(name="stream")
	private String stream;
	@Column(name="sub_Stream")
	private String subStream;
	@Column(name="client_process_id")
	private Long clientProcessId;
	@Column(name="contract_no")
	private String contractNo; 
	
	public CandidateSowPesEntity(){
		super();
	}
	
	public CandidateSowPesEntity(Long clientProcessId, String name, String stream, String subStream) {
		super();
		this.clientProcessId = clientProcessId;
		this.name = name;
		this.stream = stream;
		this.subStream = subStream;
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
	public String getSubStream() {
		return subStream;
	}
	public void setSubStream(String subStream) {
		this.subStream = subStream;
	}

	public Long getClientProcessId() {
		return clientProcessId;
	}
	public void setClientProcessId(Long clientProcessId) {
		this.clientProcessId = clientProcessId;
	}

	public String getSowNo() {
		return sowNo;
	}

	public void setSowNo(String sowNo) {
		this.sowNo = sowNo;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

}
