package com.nem.docms.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nem.docms.entities.Ad_Payment;

@Repository
public interface Ad_PaymentRepository extends MongoRepository<Ad_Payment, String>{

}
