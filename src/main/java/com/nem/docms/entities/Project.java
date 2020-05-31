package com.nem.docms.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//Data annotation with lombok to reduce code lines
@Document
public class Project {
	
	@Id
	private String id; 
	private String name; 
	private String description;
	
	
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
