package com.nem.docms.entities;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.NonNull;

public @Data class Project {
	
	@Id
	private @NonNull String id;
	private @NonNull String name; 
	private @NonNull String description;
	
}
