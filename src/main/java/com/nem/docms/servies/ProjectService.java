package com.nem.docms.servies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nem.docms.entities.Project;
import com.nem.docms.repositories.ProjectRepository;

@Service 
public class ProjectService {
	
	@Autowired
	ProjectRepository repository;

	public List<Project> getAll() {
		// TODO Auto-generated method stub
		return repository.getAll();
	}

	public String add(Project pro) {
		// TODO Auto-generated method stub
		return repository.save(pro);
	}

	public List<Project> update() {
		// TODO Auto-generated method stub
		return repository.update();
	}

	public List<Project> delete() {
		// TODO Auto-generated method stub
		return repository.delete();
	}

}
