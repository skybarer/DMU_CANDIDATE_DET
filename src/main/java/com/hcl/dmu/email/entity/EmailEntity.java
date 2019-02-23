package com.hcl.dmu.email.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dmu_email_properties")
public class EmailEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "host")
	private String host;
	@Column(name = "port")
	private Long port;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "protocol")
	private String protocol;
	@Column(name = "auth")
	private Boolean auth;
	@Column(name = "enable_starttls")
	private Boolean enableStartTLS;
	@Column(name = "debug")
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
