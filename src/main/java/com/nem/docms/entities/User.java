package com.nem.docms.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
public class User {
	
	@Id
	private String id;
	private String username;
	private String password;
	private boolean valid;
	
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User(String username, String password, boolean valid) {
		super();
		this.username = username;
		this.password = password;
		this.valid = valid;
	}

	public User(String id, String username, String password, boolean valid) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.valid = valid;
	}

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
	
	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
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

		
}
