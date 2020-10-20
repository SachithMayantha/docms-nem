package com.nem.docms.repositories;

import com.nem.docms.entities.DoUpload;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoUploadRepository extends MongoRepository<DoUpload, String> {
}
