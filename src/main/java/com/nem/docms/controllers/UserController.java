package com.nem.docms.controllers;

import com.nem.docms.entities.User;
import com.nem.docms.servies.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/allUsers")
	public String getAll(Model model) {
//		System.out.println("User List Controller called");
		List<User> listUser = userService.getAll();
		model.addAttribute("listUser", listUser);

		return "user";
	}

	@GetMapping("/getUser/{id}")
	public User getProject(@PathVariable("id") String id) {
		return userService.getUser(id);
	}

	@PostMapping("/addUser")
	// RequestBody for bind request HTTP body with a domain object
	public RedirectView addUser(User user) {
		userService.addUser(user);
		return new RedirectView("/user/allUsers");
	}

	@PostMapping("/update")
	public RedirectView update(User user) {
		System.out.println("Update Controller");
		String[] part1 = user.getUsername().split(",");
		String[] part2 = user.getId().split(",");

		user.setUsername(part1[0]);
		user.setId(part2[0]);
		System.out.println(user.getUsername());
		userService.update(user);
		return new RedirectView("/user/allUsers");
	}

	@PostMapping("/delete")
	// PathParam for map variable URI path to method call
	public RedirectView delete(@RequestParam String id) {
//		System.out.println("user Controller delete()");
		userService.delete(id);
		return new RedirectView("/user/allUsers");
	}
}
