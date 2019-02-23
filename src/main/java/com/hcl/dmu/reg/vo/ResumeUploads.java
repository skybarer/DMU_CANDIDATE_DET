package com.hcl.dmu.reg.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ResumeUploads {
	
	private Long id;
	private String profilePath;
	@JsonIgnore
	private String candidateName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
}
