package com.nem.docms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/login")
	public String login() {
//		System.out.println("Main Controller login()");
		return "login";
	}

	@GetMapping("/main")
	public String main() {
		return "main";
	}

	@GetMapping("/errors")
	public String errors() {
		return "errors";
	}


//	private int getErrorCode(HttpServletRequest httpRequest) {
//		return (Integer) httpRequest
//				.getAttribute("javax.servlet.error.status_code");
//	}
}
