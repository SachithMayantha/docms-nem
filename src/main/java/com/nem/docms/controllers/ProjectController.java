package com.nem.docms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nem.docms.entities.Project;
import com.nem.docms.servies.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	
	@GetMapping("/allProjects")
	public List<Project> getAll(){
		return projectService.getAll();
	}
	
	@GetMapping("/getProject/{id}")
	public Project getProject(@PathVariable("id") String id) {
		return projectService.getProject(id);
	}
	
	@PostMapping("/addProject")
	//RequestBody for bind request HTTP body with a domain object 
	public Project  addProject(@RequestBody Project pro){
		return projectService.addProject(pro);
	}
	
	@PutMapping("/update/{id}") 
	public Project update(@RequestBody Project pro){
		return projectService.update(pro);
	}
	
	@DeleteMapping("/delete")
	//PathParam for map variable URI path to method call
	public void delete(@RequestParam String id){
		projectService.delete(id);
	}
}
