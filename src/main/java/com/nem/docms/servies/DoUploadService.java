package com.nem.docms.servies;

import com.nem.docms.entities.DoUpload;
import com.nem.docms.repositories.DoUploadRepository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.SocketException;

@Service
public class DoUploadService {
    @Autowired
    DoUploadRepository doUploadRepository;

    @Autowired
    GridFsTemplate gridFsTemplate;

    @Autowired
    GridFsOperations gridFsOperations;

    public DoUpload addDocument(String title, MultipartFile file, String id) throws IOException, SocketException {

        DoUpload doUpload = new DoUpload(title);
        doUpload.setId(id);
        System.out.println("Get Byte "+file.getBytes());
        doUpload.setDoc(
                new Binary(BsonBinarySubType.BINARY, file.getBytes()));

        return doUploadRepository.insert(doUpload);
    }

    public DoUpload getDocument(String id) {
        return doUploadRepository.findById(id).get();
    }
}
