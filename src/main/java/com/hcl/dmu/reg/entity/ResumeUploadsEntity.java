package com.hcl.dmu.reg.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="dmu_resume_uploads")
public class ResumeUploadsEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="candidate_id",nullable=false)
	private CandidateDetEntity candidateDetEntity;
	private String profilePath;
	private String candidateName;
	@Version
	private long version;
	
	public long getVersion() {
		return version;
	}
	public void setVersion(long version) {
		this.version = version;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public CandidateDetEntity getCandidateDetEntity() {
		return candidateDetEntity;
	}
	public void setCandidateDetEntity(CandidateDetEntity candidateDetEntity) {
		this.candidateDetEntity = candidateDetEntity;
	}
	public String getProfilePath() {
		return profilePath;
	}
	public void setProfilePath(String profilePath) {
		this.profilePath = profilePath;
	}
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	@Override
	public String toString() {
		return "ResumeUploadsEntity [id=" + id + ", candidateDetEntity=" + candidateDetEntity + ", profilePath="
				+ profilePath + ", candidateName=" + candidateName + ", version=" + version + "]";
	}
	
	
	
	
	
}
