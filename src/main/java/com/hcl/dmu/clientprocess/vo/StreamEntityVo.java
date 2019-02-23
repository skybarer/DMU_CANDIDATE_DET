package com.hcl.dmu.clientprocess.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class StreamEntityVo {

	private Long id;

	private String streamName;

	private String isActive;

	@JsonIgnore
	List<SubStreamEntityVo> subStreamEntity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreamName() {
		return streamName;
	}

	public void setStreamName(String streamName) {
		this.streamName = streamName;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	
	public List<SubStreamEntityVo> getSubStreamEntity() {
		return subStreamEntity;
	}

	public void setSubStreamEntity(List<SubStreamEntityVo> subStreamEntity) {
		this.subStreamEntity = subStreamEntity;
	}

	@Override
	public String toString() {
		return "StreamEntityVo [id=" + id + ", streamName=" + streamName + ", isActive=" + isActive
				+ ", subStreamEntity=" + subStreamEntity + "]";
	}

}
