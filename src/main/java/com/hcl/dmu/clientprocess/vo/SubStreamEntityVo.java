package com.hcl.dmu.clientprocess.vo;

public class SubStreamEntityVo {
	
	private Long id;

	private String subStreamName;
	
	private String isActive;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubStreamName() {
		return subStreamName;
	}

	public void setSubStreamName(String subStreamName) {
		this.subStreamName = subStreamName;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "SubStreamEntityVo [id=" + id + ", subStreamName=" + subStreamName + ", isActive=" + isActive + "]";
	}

	
	

}
