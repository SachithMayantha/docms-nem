package com.nem.docms.servies;

import com.nem.docms.entities.Project;
import com.nem.docms.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

	private final ProjectRepository projectRepository;

	public ProjectService(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	public List<Project> getAll() {
		// TODO Auto-generated method stub
//		System.out.println("project list service called");
		return projectRepository.findAll();
	}

	public Project getProject(String id) {
		// TODO Auto-generated method stub
		return projectRepository.findById(id).get();
	}

	public Project addProject(Project pro) {
		// TODO Auto-generated method stub
		return projectRepository.insert(pro);
	}

	public Project update(Project pro) {
		System.out.println("Get Project Name "+pro.getName());
		System.out.println("Get Project ID "+pro.getId());
		System.out.println("Get Project Description "+pro.getDescription());
		// TODO Auto-generated method stub
		return projectRepository.save(pro);
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
		projectRepository.deleteById(id);
	}

}
