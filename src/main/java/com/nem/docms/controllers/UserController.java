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

import com.nem.docms.entities.User;
import com.nem.docms.servies.UserService;

@RequestMapping
@RestController
public class UserController {
	/*@Autowired
	UserService service;
	
	@GetMapping("/getUser")
	public List<User> getAll(){
		return service.getAll();
	}
	@PostMapping("/addUser")
	//RequestBody for bind request HTTP body with a domain object 
	public String  add(@RequestBody User user){
		return service.add(user);
	}
	@PutMapping("/updateUser")
	public String update(@RequestBody User user){
		return service.update(user);
	}
	@DeleteMapping("/deleteUser")
	//PathParam for map variable URI path to method call
	public String delete(@PathParam("id") String id){
		return service.delete(id);
	}*/
}
