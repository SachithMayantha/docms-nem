package com.nem.docms.entities;

import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
public class User {
	
	private String id;
	private String username;
	private String password;
	
    private Set<Role> roles;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	
		
}
