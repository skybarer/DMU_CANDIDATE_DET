/**
 * 
 */
package com.hcl.dmu.email.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author sekhar.k
 *
 */
@Entity
@Table(name="email_log")
public class EmailLogEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="subject")
	private String subject;
	@Column(name="message")
	private String message;
	@Column(name="from")
	private String from;
	@Column(name="to")
	private String to;
	@Column(name="bcc")
	private String bcc;
	@Column(name="cc")
	private String cc;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
