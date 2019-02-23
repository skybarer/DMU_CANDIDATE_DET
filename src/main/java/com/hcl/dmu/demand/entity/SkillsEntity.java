package com.hcl.dmu.demand.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dmu_skill")
public class SkillsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "primary_skill")
	private String primarySkill;
	
	@Column(name = "secondary_skill")
	private String secondarySkill;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrimarySkill() {
		return primarySkill;
	}

	public void setPrimarySkill(String primarySkill) {
		this.primarySkill = primarySkill;
	}

	public String getSecondarySkill() {
		return secondarySkill;
	}

	public void setSecondarySkill(String secondarySkill) {
		this.secondarySkill = secondarySkill;
	}

	@Override
	public String toString() {
		return "SkillsEntity [id=" + id + ", primarySkill=" + primarySkill + ", SecondarySkill=" + secondarySkill + "]";
	}
	
	
	
	

}
