package com.nem.docms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nem.docms.entities.Project;
import com.nem.docms.servies.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	ProjectService service;
	
	@GetMapping("/")
	public List<Project> getAll(){
		return service.getAll();
	}
	@PostMapping("/")
	public List<Project> add(){
		return service.add();
	}
	@PutMapping("/")
	public List<Project> update(){
		return service.update();
	}
	@DeleteMapping("/")
	public List<Project> delete(){
		return service.delete();
	}
}
