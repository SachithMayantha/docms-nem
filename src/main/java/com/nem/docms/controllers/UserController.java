package com.nem.docms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.nem.docms.entities.User;
import com.nem.docms.servies.UserService;

@RequestMapping("/user")
@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping("/allUsers")
	public String getAll(Model model){
		
		System.out.println("User List Controller called");
		List<User> listUser = userService.getAll();
		model.addAttribute("listUser",listUser);
		
		return "user";
	}
	
	@GetMapping("/getUser/{id}")
	public User getProject(@PathVariable("id") String id) {
		return userService.getUser(id);
	}
	
	@PostMapping("/addUser")
	//RequestBody for bind request HTTP body with a domain object 
	public User  addUser(@RequestBody User user){
		return userService.addUser(user);
	}
	
	@PutMapping("/update/{id}") 
	public User update(@RequestBody User user){
		return userService.update(user);
	}
	
	@DeleteMapping("/delete")
	//PathParam for map variable URI path to method call
	public void delete(@RequestParam String id){
		userService.delete(id);
	}
}
