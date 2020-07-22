package com.nem.docms.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nem.docms.entities.Retention;

@Repository
public interface RetentionRepository extends MongoRepository<Retention, String>{

}
