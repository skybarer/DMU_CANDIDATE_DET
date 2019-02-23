package com.hcl.dmu.user.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dmu_roles")
public class RolesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy="role")
    private UserEntity userEntity;
	
	@Column(name = "role_name")
	private String roleName;

	@Column(name = "active_inactive")
	private Boolean activeInactive;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Boolean getActiveInactive() {
		return activeInactive;
	}

	public void setActiveInactive(Boolean activeInactive) {
		this.activeInactive = activeInactive;
	}

}
