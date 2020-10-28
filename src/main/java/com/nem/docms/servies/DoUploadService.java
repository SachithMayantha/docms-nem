package com.nem.docms.servies;

import com.nem.docms.entities.DoUpload;
import com.nem.docms.repositories.DoUploadRepository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class DoUploadService {
    private final DoUploadRepository doUploadRepository;
    private final GridFsTemplate gridFsTemplate;
    private final GridFsOperations gridFsOperations;

    public DoUploadService(DoUploadRepository doUploadRepository, GridFsTemplate gridFsTemplate, GridFsOperations gridFsOperations) {
        this.doUploadRepository = doUploadRepository;
        this.gridFsTemplate = gridFsTemplate;
        this.gridFsOperations = gridFsOperations;
    }

    public DoUpload addDocument(String title, MultipartFile file, String id) throws IOException {

        DoUpload doUpload = new DoUpload(title);
        doUpload.setId(id);
//        System.out.println("Get Byte "+file.getBytes());
        doUpload.setDoc(
                new Binary(BsonBinarySubType.BINARY, file.getBytes()));

        return doUploadRepository.insert(doUpload);
    }

    public DoUpload getDocument(String id) {
        return doUploadRepository.findById(id).get();
    }
}
