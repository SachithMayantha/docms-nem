package com.nem.docms.service;

import java.util.List;

import com.nem.docms.entity.Project;

public interface ProjectService {
    Project save(Project project);

    Project update(Project project);

    List<Project> getAllProject();


    
}