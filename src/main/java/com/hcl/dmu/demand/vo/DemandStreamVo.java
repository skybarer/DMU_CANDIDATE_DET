package com.hcl.dmu.demand.vo;

public class DemandStreamVo {

	private Long id;
	private String streamName;
	private String subStreamName;
	private String skill;

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

	public String getSubStreamName() {
		return subStreamName;
	}

	public void setSubStreamName(String subStreamName) {
		this.subStreamName = subStreamName;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	@Override
	public String toString() {
		return "StreamVo [streamName=" + streamName + ", subStreamName=" + subStreamName + ", skill=" + skill + "]";
	}

}
