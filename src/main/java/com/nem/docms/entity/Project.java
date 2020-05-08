package com.nem.docms.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document(collation = "Project")
public class Project {
    @Id
    private String id;
    @Field(value = "name")
    private String name;
    @Field(value = "description")
    private String description;
}