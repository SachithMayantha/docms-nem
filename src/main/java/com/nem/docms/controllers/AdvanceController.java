package com.nem.docms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nem.docms.entities.Advance;
import com.nem.docms.servies.AdvanceService;

@RestController
@RequestMapping("/advance")
public class AdvanceController {
	
	@Autowired
	AdvanceService advanceService;
	
	@GetMapping("/allAdvance")
	public List<Advance> getAll(){
		return advanceService.getAll();
	}
	
	@GetMapping("/getAdvance/{id}")
	public Advance getAdvance(@PathVariable("id") String id) {
		return advanceService.getAdvance(id);
	}
	
	@PostMapping("/addAdvance")
	//RequestBody for bind request HTTP body with a domain object 
	public Advance  addAdvance(@RequestBody Advance ad){
		return advanceService.addAdvance(ad);
	}
	
	@PutMapping("/update/{id}") 
	public Advance update(@RequestBody Advance ad){
		return advanceService.update(ad);
	}
	
	@DeleteMapping("/delete")
	//PathParam for map variable URI path to method call
	public void delete(@RequestParam String id){
		advanceService.delete(id);
	}
}
