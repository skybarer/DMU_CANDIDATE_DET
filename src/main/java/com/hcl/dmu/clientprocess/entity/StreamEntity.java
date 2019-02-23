package com.hcl.dmu.clientprocess.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "dmu_streams_details")
public class StreamEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "stream_name")
	private String streamName;

	@Column(name = "is_active")
	private String isActive;

	@OneToMany(cascade = CascadeType.ALL,mappedBy="streamEntity")
	private List<SubStreamEntity> subStreamEntity;

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

	public List<SubStreamEntity> getSubStreamEntity() {
		return subStreamEntity;
	}

	public void setSubStreamEntity(List<SubStreamEntity> subStreamEntity) {
		this.subStreamEntity = subStreamEntity;
	}

	@Override
	public String toString() {
		return "StreamEntity [id=" + id + ", streamName=" + streamName + ", isActive=" + isActive + ", subStreamEntity="
				+ subStreamEntity + "]";
	}

}
