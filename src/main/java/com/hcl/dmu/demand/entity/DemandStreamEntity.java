package com.hcl.dmu.demand.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "dmu_streams")
public class DemandStreamEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "stream_Name")
	private String streamName;
	
	@Column(name = "sub_Stream_Name")
	private String subStreamName;
	
	@Column(name = "skill")
	private String skill;
	
	
	
	@Column(name="version")
	@Version
	private long version;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
		return "DemandStreamEntity [id=" + id + ", streamName=" + streamName + ", subStreamName=" + subStreamName
				+ ", skill=" + skill + ", version=" + version + "]";
	}
	
	

}
