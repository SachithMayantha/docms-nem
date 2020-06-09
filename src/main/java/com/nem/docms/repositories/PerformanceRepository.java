package com.nem.docms.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nem.docms.entities.Performance;

@Repository
public interface PerformanceRepository extends MongoRepository<Performance, String>{

}
