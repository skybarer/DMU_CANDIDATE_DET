package com.hcl.dmu.demand.vo;

public class DemandDetailsVoForSearch {
	private DemandStreamVo StreamId;
	private SkillVo skillId;
	private long count;
	private long fullfilled;

	public DemandStreamVo getStreamId() {
		return StreamId;
	}

	public void setStreamId(DemandStreamVo streamId) {
		StreamId = streamId;
	}

	public SkillVo getSkillId() {
		return skillId;
	}

	public void setSkillId(SkillVo skillId) {
		this.skillId = skillId;
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

	
}
