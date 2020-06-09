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

import com.nem.docms.entities.BidBond;
import com.nem.docms.servies.BidBondService;

@RestController
@RequestMapping("/bidBond")
public class BidBondController {
	
	@Autowired
	BidBondService bidBondService;

	@GetMapping("/allAdvance")
	public List<BidBond> getAll(){
		return bidBondService.getAll();
	}
	
	@GetMapping("/getBidBond/{id}")
	public BidBond getBidBond(@PathVariable("id") String id) {
		return bidBondService.getBidBond(id);
	}
	
	@PostMapping("/addBidBond")
	//RequestBody for bind request HTTP body with a domain object 
	public BidBond  addBidBond(@RequestBody BidBond bid){
		return bidBondService.addBidBond(bid);
	}
	
	@PutMapping("/update/{id}") 
	public BidBond update(@RequestBody BidBond bid){
		return bidBondService.update(bid);
	}
	
	@DeleteMapping("/delete")
	//PathParam for map variable URI path to method call
	public void delete(@RequestParam String id){
		bidBondService.delete(id);
	}
}
