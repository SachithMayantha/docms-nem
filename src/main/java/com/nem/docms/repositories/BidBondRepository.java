package com.nem.docms.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nem.docms.entities.BidBond;

@Repository
public interface BidBondRepository extends MongoRepository<BidBond, String>{

}
