package com.nem.docms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/main")
	public String main() {
		return "main";
	}
	@GetMapping("/bidbond")
	public String bidbond() {
		return "bidbond";
	}
	@GetMapping("/advance")
	public String advance() {
		return "advance";
	}
	@GetMapping("/performance")
	public String performance() {
		return "performance";
	}
	@GetMapping("/retention")
	public String retention() {
		return "retention";
	}
	@GetMapping("/users")
	public String users() {
		return "users";
	}
}
