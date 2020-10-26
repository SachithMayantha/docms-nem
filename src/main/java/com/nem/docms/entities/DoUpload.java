package com.nem.docms.entities;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "document")
public class DoUpload {
    @Id
    private String id;
    private String title;
    private Binary doc;

    public DoUpload(String title) {
        this.title = title;
    }
}

