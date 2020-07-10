package com.nem.docms.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nem.docms.entities.Role;

public interface RoleRepository extends MongoRepository<Role, String>{

}
