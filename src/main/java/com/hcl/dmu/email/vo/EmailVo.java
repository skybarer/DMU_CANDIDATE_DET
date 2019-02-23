package com.hcl.dmu.email.vo;

public class EmailVo {
	
	private Long id;
	private String host;
	private Long port;
	private String username;
	private String password;
	private String protocol;
	private Boolean auth;
	private Boolean enableStartTLS;
	private Boolean debug;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public Long getPort() {
		return port;
	}
	public void setPort(Long port) {
		this.port = port;
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
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public Boolean getAuth() {
		return auth;
	}
	public void setAuth(Boolean auth) {
		this.auth = auth;
	}
	public Boolean getEnableStartTLS() {
		return enableStartTLS;
	}
	public void setEnableStartTLS(Boolean enableStartTLS) {
		this.enableStartTLS = enableStartTLS;
	}
	public Boolean getDebug() {
		return debug;
	}
	public void setDebug(Boolean debug) {
		this.debug = debug;
	}
}
