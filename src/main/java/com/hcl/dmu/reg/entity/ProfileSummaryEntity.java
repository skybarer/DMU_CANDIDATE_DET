package com.hcl.dmu.reg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dmu_profile_summary")
public class ProfileSummaryEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="profile_description",columnDefinition="TEXT")
	private String profileDescription;
	
	@Column(name="profile_line1",columnDefinition="TEXT")
	private String profileLine1;

	@Column(name="profile_line2",columnDefinition="TEXT")
	private String profileLine2;
	
	@Column(name="profile_line3",columnDefinition="TEXT")
	private String profileLine3;
	
	@Column(name="profile_line4",columnDefinition="TEXT")
	private String profileLine4;
	
	@Column(name="experience_line1",columnDefinition="TEXT")
	private String experienceLine1;
	
	@Column(name="experience_line2",columnDefinition="TEXT")
	private String experienceLine2;
	
	@Column(name="experience_line3",columnDefinition="TEXT")
	private String experienceLine3;
	
	@Column(name="experience_line4",columnDefinition="TEXT")
	private String experienceLine4;
	
	@Column(name="highlights_line1",columnDefinition="TEXT")
	private String highlightsLine1;
	
	@Column(name="highlights_line2",columnDefinition="TEXT")
	private String highlightsLine2;
	
	@Column(name="highlights_line3",columnDefinition="TEXT")
	private String highlightsLine3;
	
	@Column(name="highlights_line4",columnDefinition="TEXT")
	private String highlightsLine4;
	
	@Column(name="candidate_id",unique=true)
	private Long candidateId;
	
	@Column(name="photo")
	private String photo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProfileDescription() {
		return profileDescription;
	}

	public void setProfileDescription(String profileDescription) {
		this.profileDescription = profileDescription;
	}

	public String getProfileLine1() {
		return profileLine1;
	}

	public void setProfileLine1(String profileLine1) {
		this.profileLine1 = profileLine1;
	}

	public String getProfileLine2() {
		return profileLine2;
	}

	public void setProfileLine2(String profileLine2) {
		this.profileLine2 = profileLine2;
	}

	public String getProfileLine3() {
		return profileLine3;
	}

	public void setProfileLine3(String profileLine3) {
		this.profileLine3 = profileLine3;
	}

	public String getProfileLine4() {
		return profileLine4;
	}

	public void setProfileLine4(String profileLine4) {
		this.profileLine4 = profileLine4;
	}

	public String getExperienceLine1() {
		return experienceLine1;
	}

	public void setExperienceLine1(String experienceLine1) {
		this.experienceLine1 = experienceLine1;
	}

	public String getExperienceLine2() {
		return experienceLine2;
	}

	public void setExperienceLine2(String experienceLine2) {
		this.experienceLine2 = experienceLine2;
	}

	public String getExperienceLine3() {
		return experienceLine3;
	}

	public void setExperienceLine3(String experienceLine3) {
		this.experienceLine3 = experienceLine3;
	}

	public String getExperienceLine4() {
		return experienceLine4;
	}

	public void setExperienceLine4(String experienceLine4) {
		this.experienceLine4 = experienceLine4;
	}

	public String getHighlightsLine1() {
		return highlightsLine1;
	}

	public void setHighlightsLine1(String highlightsLine1) {
		this.highlightsLine1 = highlightsLine1;
	}

	public String getHighlightsLine2() {
		return highlightsLine2;
	}

	public void setHighlightsLine2(String highlightsLine2) {
		this.highlightsLine2 = highlightsLine2;
	}

	public String getHighlightsLine3() {
		return highlightsLine3;
	}

	public void setHighlightsLine3(String highlightsLine3) {
		this.highlightsLine3 = highlightsLine3;
	}

	public String getHighlightsLine4() {
		return highlightsLine4;
	}

	public void setHighlightsLine4(String highlightsLine4) {
		this.highlightsLine4 = highlightsLine4;
	}

	public Long getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
