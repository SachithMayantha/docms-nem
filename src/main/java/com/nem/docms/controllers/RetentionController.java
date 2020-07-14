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
import com.nem.docms.entities.Retention;
import com.nem.docms.servies.RetentionService;

@Controller
@RequestMapping("/retention")
public class RetentionController {
	
	@Autowired
	RetentionService retentionService;
	
	@GetMapping("/allRetention")
	public String getAll(Model model){
		
		System.out.println("Retention List Controller called");
		List<Retention> listRetention = retentionService.getAll();
		model.addAttribute("listRetention",listRetention);
		
		return "retention";
	}
	
	@GetMapping("/getRetention/{id}")
	public Retention getRetention(@PathVariable("id") String id) {
		return retentionService.getRetention(id);
	}
	
	@PostMapping("/addRetention")
	//RequestBody for bind request HTTP body with a domain object 
	public Retention  addRetention(@RequestBody Retention ret){
		return retentionService.addRetention(ret);
	}
	
	@PutMapping("/update/{id}") 
	public Retention update(@RequestBody Retention ret){
		return retentionService.update(ret);
	}
	
	@DeleteMapping("/delete")
	//PathParam for map variable URI path to method call
	public void delete(@RequestParam String id){
		retentionService.delete(id);
	}

}
