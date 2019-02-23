package com.hcl.dmu.demand.entity;

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
@Table(name = "dmu_secondary_skill")
public class SecondarySkillEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="secondary_skill_name")
	private String secondarySkillName;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "primary_skill_id",nullable=false)
	private PrimarySkillEntity primarySkillEntity;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSecondarySkillName() {
		return secondarySkillName;
	}

	public void setSecondarySkillName(String secondarySkillName) {
		this.secondarySkillName = secondarySkillName;
	}

	public PrimarySkillEntity getPrimarySkillEntity() {
		return primarySkillEntity;
	}

	public void setPrimarySkillEntity(PrimarySkillEntity primarySkillEntity) {
		this.primarySkillEntity = primarySkillEntity;
	}
}
