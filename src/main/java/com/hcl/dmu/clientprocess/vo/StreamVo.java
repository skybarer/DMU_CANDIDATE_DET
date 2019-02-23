package com.hcl.dmu.clientprocess.vo;

public class StreamVo {
	
	private int id;
	private String streamName;
	private String subStreamName;

	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	
	
	@Override
	public String toString() {
		return "StreamVo [id=" + id + ", streamName=" + streamName + ", subStreamName=" + subStreamName + "]";
	}
}
