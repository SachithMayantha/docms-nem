package com.nem.docms.controllers;

import com.nem.docms.entities.Project;
import com.nem.docms.servies.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

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
        try {
            projectService.addProject(pro);
            return new RedirectView("/project/allProjects");
        } catch (Exception e) {
            e.printStackTrace();
            return new RedirectView("/errors");
        }
    }

    @PostMapping("/update")
    public RedirectView update(Project pro) {
        System.out.println("Project Update Controller called");
        try {
            String[] parts = pro.getName().split(",");
            pro.setName(parts[0]);
            projectService.update(pro);

            return new RedirectView("/project/allProjects");
        } catch (Exception e) {
            e.printStackTrace();
            return new RedirectView("/errors");
        }
    }

    @PostMapping("/delete")
    // PathParam for map variable URI path to method call
    public RedirectView delete(@RequestParam String id) {
//		System.out.println("Project Controller delete()");
        try {
            projectService.delete(id);
        return new RedirectView("/project/allProjects");
        }catch (Exception e){
            e.printStackTrace();
            return new RedirectView("/errors");
        }
    }
}
