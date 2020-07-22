package com.nem.docms.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nem.docms.entities.Project;

@Repository
public interface ProjectRepository extends MongoRepository<Project, String> {
	
}
