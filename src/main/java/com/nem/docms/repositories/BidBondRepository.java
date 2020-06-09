package com.nem.docms.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nem.docms.entities.BidBond;

public interface BidBondRepository extends MongoRepository<BidBond, String>{

}
