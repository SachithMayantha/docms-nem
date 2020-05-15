package com.nem.docms.entities;

import lombok.Data;
import lombok.NonNull;

//Data annotation with lombok to reduce code lines
public @Data class Project {
	
	private @NonNull String id; 
	private @NonNull String name; 
	private @NonNull String description;
	
}
