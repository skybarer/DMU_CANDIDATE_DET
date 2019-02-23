package com.hcl.dmu.sowpes.vo;

public class CandidateSowPesVo {

	private Long id;
	private String name;
	private String sowNo;
	private String status;
	private String stream;
	private String subStream;
	private Long clientProcessId;
	private String contractNo;

	public CandidateSowPesVo() {
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

	@Override
	public String toString() {
		return "CandidateSowPesVo [id=" + id + ", name=" + name + ", sowNo=" + sowNo + ", status=" + status
				+ ", stream=" + stream + ", subStream=" + subStream + ", clientProcessId=" + clientProcessId
				+ ", contractNo=" + contractNo + "]";
	}
}
