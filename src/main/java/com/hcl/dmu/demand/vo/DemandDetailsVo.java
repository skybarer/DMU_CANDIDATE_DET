package com.hcl.dmu.demand.vo;

public class DemandDetailsVo {
	private Long Id;
	private String streamName;
	private String subStreamName;
	private String skillName;
	private long count;
	private long fullfilled;
	private long gap;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
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

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public long getFullfilled() {
		return fullfilled;
	}

	public void setFullfilled(long fullfilled) {
		this.fullfilled = fullfilled;
	}

	public long getGap() {
		return gap;
	}

	public void setGap(long gap) {
		this.gap = gap;
	}

}
