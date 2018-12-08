package com.crud.project.jsf.primafaces.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.crud.project.jsf.primafaces.base.BaseEntities;

@Entity
@Table(name="Users")
@AttributeOverride(name = "id", column = @Column(name = "UserID"))
public class UserEntity extends BaseEntities<Long> {

	private static final long serialVersionUID = -2284802327843579757L;

	private String name;

	private String username;

	private String password;

	private String role;
	
	public UserEntity() {
		// TODO Auto-generated constructor stub
	}

	public UserEntity(String name, String username, String password, String role) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}