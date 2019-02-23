package com.hcl.dmu.user.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class RolesVo {
	private Long id;
	private Boolean activeInactive;
	@JsonIgnore
	private UserVo userVo;
	private String roleName;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Boolean getActiveInactive() {
		return activeInactive;
	}

	public void setActiveInactive(Boolean activeInactive) {
		this.activeInactive = activeInactive;
	}

	public UserVo getUserVo() {
		return userVo;
	}

	public void setUserVo(UserVo userVo) {
		this.userVo = userVo;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "RolesVo [id=" + id + ", activeInactive=" + activeInactive + ", userVo=" + userVo + ", roleName="
				+ roleName + "]";
	}
}
