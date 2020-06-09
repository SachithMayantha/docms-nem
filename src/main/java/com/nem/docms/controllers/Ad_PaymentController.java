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

import com.nem.docms.entities.Ad_Payment;
import com.nem.docms.servies.Ad_PaymentService;

@RestController
@RequestMapping("/ad_payment")
public class Ad_PaymentController {
	
	@Autowired
	Ad_PaymentService adService;
	
	@GetMapping("/allAd_Payment")
	public List<Ad_Payment> getAll(){
		return adService.getAll();
	}
	
	@GetMapping("/getProject/{id}")
	public Ad_Payment getAd_Payment(@PathVariable("id") String id) {
		return adService.getAd_Payment(id);
	}
	
	@PostMapping("/addProject")
	//RequestBody for bind request HTTP body with a domain object 
	public Ad_Payment  addAd_Payment(@RequestBody Ad_Payment ad){
		return adService.addAd_Payment(ad);
	}
	
	@PutMapping("/update/{id}") 
	public Ad_Payment update(@RequestBody Ad_Payment ad){
		return adService.update(ad);
	}
	
	@DeleteMapping("/delete")
	//PathParam for map variable URI path to method call
	public void delete(@RequestParam String id){
		adService.delete(id);
	}
	
}
