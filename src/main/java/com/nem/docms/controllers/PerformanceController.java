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

import com.nem.docms.entities.Performance;
import com.nem.docms.servies.PerformanceService;

@RestController
@RequestMapping("/performance")
public class PerformanceController {
	
	@Autowired
	PerformanceService performanceService;
	
	@GetMapping("/allPerformance")
	public List<Performance> getAll(){
		return performanceService.getAll();
	}
	
	@GetMapping("/getPerformance/{id}")
	public Performance getPerformance(@PathVariable("id") String id) {
		return performanceService.getPerformance(id);
	}
	
	@PostMapping("/addPerformance")
	//RequestBody for bind request HTTP body with a domain object 
	public Performance  addPerformance(@RequestBody Performance per){
		return performanceService.addPerformance(per);
	}
	
	@PutMapping("/update/{id}") 
	public Performance update(@RequestBody Performance per){
		return performanceService.update(per);
	}
	
	@DeleteMapping("/delete")
	//PathParam for map variable URI path to method call
	public void delete(@RequestParam String id){
		performanceService.delete(id);
	}

}
