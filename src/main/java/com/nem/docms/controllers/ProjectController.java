package com.nem.docms.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	//RequestBody for bind request HTTP body with a domain object 
	public String  add(@RequestBody Project pro){
		return service.add(pro);
	}
	@PutMapping("/")
	public String update(@RequestBody Project pro){
		return service.update(pro);
	}
	@DeleteMapping("/")
	//PathParam for map variable URI path to method call
	public String delete(@PathParam("id") String id){
		return service.delete(id);
	}
}
