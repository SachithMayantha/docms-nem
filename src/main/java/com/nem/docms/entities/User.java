package com.nem.docms.entities;

import lombok.Data;
import lombok.NonNull;

public @Data class User {
	private @NonNull String id;
	private @NonNull String name;
	private @NonNull String password;
	
}
