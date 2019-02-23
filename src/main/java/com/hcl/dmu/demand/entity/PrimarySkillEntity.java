package com.hcl.dmu.demand.entity;

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
@Table(name = "dmu_primary_skill")
public class PrimarySkillEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="primary_skill_name",unique=true)
	private String primarySkillName;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="primarySkillEntity")
	private List<SecondarySkillEntity> secondarySkillEntities;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPrimarySkillName() {
		return primarySkillName;
	}

	public void setPrimarySkillName(String primarySkillName) {
		this.primarySkillName = primarySkillName;
	}

	public List<SecondarySkillEntity> getSecondarySkillEntities() {
		return secondarySkillEntities;
	}

	public void setSecondarySkillEntities(List<SecondarySkillEntity> secondarySkillEntities) {
		this.secondarySkillEntities = secondarySkillEntities;
	}
}
