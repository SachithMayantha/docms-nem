package com.nem.docms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.nem.docms.entities.Project;
import com.nem.docms.servies.ProjectService;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	ProjectService projectService;

	@GetMapping("/allProjects")
	public String getAll(Model model) {
//		System.out.println("Project List Controller called");
		List<Project> listProjects = projectService.getAll();
		model.addAttribute("listProjects", listProjects);

		return "projects";
	}

	@GetMapping("/getProject/{id}")
	public Project getProject(@PathVariable("id") String id) {
		return projectService.getProject(id);
	}

	@PostMapping("/addProject")
	// RequestBody for bind request HTTP body with a domain object
	public RedirectView addProject(Project pro) {
		projectService.addProject(pro);
		return new RedirectView("/project/allProjects");
	}

	@PostMapping("/update")
	public RedirectView update(Project pro) {
		System.out.println("Project Update Controller called");
		String[] parts = pro.getName().split(",");
		pro.setName(parts[0]);
		projectService.update(pro);
		return new RedirectView("/project/allProjects");
	}

	@PostMapping("/delete")
	// PathParam for map variable URI path to method call
	public RedirectView delete(@RequestParam String id) {
//		System.out.println("Project Controller delete()");
		projectService.delete(id);
		return new RedirectView("/project/allProjects");
	}
}
