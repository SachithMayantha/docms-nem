package com.nem.docms.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "Users")
public class User {
	
	@Id
	private String id;
	private String username;
	private String password;
	private String role;
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
}
