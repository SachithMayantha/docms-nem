package com.nem.docms.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "Projects")
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
}
