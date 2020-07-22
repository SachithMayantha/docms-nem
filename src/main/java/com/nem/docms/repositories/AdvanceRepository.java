package com.nem.docms.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nem.docms.entities.Advance;

@Repository
public interface AdvanceRepository extends MongoRepository<Advance, String>{

}
