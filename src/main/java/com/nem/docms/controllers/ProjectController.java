package com.nem.docms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nem.docms.entities.Project;
import com.nem.docms.servies.ProjectService;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/project")
public class ProjectController{
	
	@Autowired
	ProjectService projectService;
	
	@GetMapping("/allProjects")
	public String getAll(Model model){
		System.out.println("Project List Controller called");
		List<Project> listProjects = projectService.getAll();
		model.addAttribute("listProjects",listProjects);
//		System.out.println(listProjects.get(0));
		return "projects";
	}
	
	@GetMapping("/getProject/{id}")
	public Project getProject(@PathVariable("id") String id) {
		return projectService.getProject(id);
	}
	
	@PostMapping("/addProject")
	//RequestBody for bind request HTTP body with a domain object 
	public String  addProject(@RequestBody Project pro){
		System.out.println("Project controller addProject()");
		//insert the retrieve data to database
		projectService.addProject(pro);
		return "projects";
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
