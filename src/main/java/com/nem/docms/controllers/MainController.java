package com.nem.docms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
	
	@GetMapping("/login")
	public String login() {
		System.out.println("Main Controller login()");
		return "login";
	}
	@PostMapping("/main")
	public String loginSuccessHandler() {
		System.out.println("Main Controller main()");
		return "main";
	}
	@PostMapping("/login")
	public String loginFailureHandler() {
		System.out.println("login failure");
		return "login";
	}
	@GetMapping("/logout")
	public String logout() {
		System.out.println("logout success");
		return "login";
	}
//	@GetMapping("/project/allProjects")
//	public String projects() {
//		System.out.println("Main Controller projects()");
//		return "projects";
//	}
}
