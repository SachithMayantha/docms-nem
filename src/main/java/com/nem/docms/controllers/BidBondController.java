package com.nem.docms.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import org.springframework.web.servlet.view.RedirectView;

import com.nem.docms.entities.BidBond;
import com.nem.docms.entities.BidBond2;
import com.nem.docms.servies.BidBondService;

@Controller
@RequestMapping("/bidBond")
public class BidBondController {
	@Autowired
	BidBondService bidBondService;

	@GetMapping("/allBidBonds")
	public String getAll(Model model){
		
		System.out.println("Bidbond List Controller called");
		//get the object list
		List<BidBond> listBidbonds = bidBondService.getAll();
		
		//get the remaining days
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String String1 = java.time.LocalDate.now().toString();
		Long remain;
		for(int i=0;i<listBidbonds.size();i++) {
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
			String String2 =simpleDateFormat.format(listBidbonds.get(i).getExpire());
			try {
				
			LocalDate date1 = LocalDate.parse(String1, dtf);
		    LocalDate date2 = LocalDate.parse(String2, dtf);
		    remain =  Duration.between(date1.atStartOfDay(), date2.atStartOfDay()).toDays();

		    System.out.println(remain);
		    listBidbonds.get(i).setRemain(remain);
		  
			}catch (Exception e) {
				System.out.println(e);
			}
			model.addAttribute("listBidbonds",listBidbonds);
		}
		
		return "bidbond";
	}
	
	@GetMapping("/getBidBond/{id}")
	public BidBond getBidBond(@PathVariable("id") String id) {
		return bidBondService.getBidBond(id);
	}
	
	@PostMapping("/addBidBond")
	//RequestBody for bind request HTTP body with a domain object 
		public RedirectView  addBidBond(BidBond2 bid) throws ParseException{
			System.out.println("BidBond controller addBidBond()");
			bidBondService.addBidBond(bid);
			return new RedirectView("/bidBond/allBidBonds");
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
