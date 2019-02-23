package com.hcl.dmu.clientprocess.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dmu_sub_streams_details")
public class SubStreamEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "sub_stream_name")
	private String subStreamName;
	
	@Column(name = "is_active")
	private String isActive;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "stream_id",nullable=false)
	private StreamEntity streamEntity;

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

	public StreamEntity getStreamEntity() {
		return streamEntity;
	}

	public void setStreamEntity(StreamEntity streamEntity) {
		this.streamEntity = streamEntity;
	}
	
	

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	

	

}
