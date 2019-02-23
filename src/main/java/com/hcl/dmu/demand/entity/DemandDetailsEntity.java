package com.hcl.dmu.demand.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "dmu_demand_details")
public class DemandDetailsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Column(name = "stream_name")
	private String streamName;

	@Column(name = "sub_stream_name")
	private String subStreamName;

	@Column(name = "skill_name")
	private String skillName;

	@Column(name = "count")
	private long count;

	@Column(name = "fullfilled")
	private long fullfilled;

	@Column(name = "gap")
	private long gap;

	@Column(name = "version")
	@Version
	private long version;

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

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
	
	

}
