package com.hcl.dmu.user.vo;

public class UserVo {

	private Long id;
	private String username;
	private String password;
	private RolesVo role;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public RolesVo getRole() {
		return role;
	}
	public void setRole(RolesVo role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserVo [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + "]";
	}
}
