package com.nem.docms.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

import com.nem.docms.entities.Advance;
import com.nem.docms.entities.Advance2;
import com.nem.docms.servies.AdvanceService;

@Controller
@RequestMapping("/advance")
public class AdvanceController {
	
	@Autowired
	AdvanceService advanceService;
	
	@GetMapping("/allAdvance")
	public String getAll(Model model){
		System.out.println("Advance controller getAll() called");
		List<Advance> listAdvance = advanceService.getAll();
		List<Advance2> list = new ArrayList<Advance2>();
		
		//get the remaining days
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String String1 = java.time.LocalDate.now().toString();
		Long remain;
		int size = listAdvance.size();
		for(int i=0;i<size;i++) {
			Advance2 ad2 = new Advance2();
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
			String String2 =simpleDateFormat.format(listAdvance.get(i).getExpire());
			try {
				
			LocalDate date1 = LocalDate.parse(String1, dtf);
		    LocalDate date2 = LocalDate.parse(String2, dtf);
		    remain =  Duration.between(date1.atStartOfDay(), date2.atStartOfDay()).toDays();

		    System.out.println(remain);
		    ad2.setRemain(remain);
		  
			}catch (Exception e) {
				System.out.println(e);
			}
			
			String ef = simpleDateFormat.format(listAdvance.get(i).getEffective());
		    String ex = simpleDateFormat.format(listAdvance.get(i).getExpire());
		    
		    ad2.setId(listAdvance.get(i).getId());
		    ad2.setName(listAdvance.get(i).getName());
		    ad2.setAmount(listAdvance.get(i).getAmount());
		    ad2.setEffective(ef);
		    ad2.setExpire(ex);
		    ad2.setStatus(listAdvance.get(i).getStatus());
			
			list.add(ad2);
			model.addAttribute("list",list);
		}
		return "advance";
	}
	
	@GetMapping("/getAdvance/{id}")
	public Advance getAdvance(@PathVariable("id") String id) {
		return advanceService.getAdvance(id);
	}
	
	@PostMapping("/addAdvance")
	//RequestBody for bind request HTTP body with a domain object 
	public RedirectView  addAdvance(Advance2 ad) throws ParseException{
		System.out.println("Advance controller addAdvance()");
		advanceService.addAdvance(ad);
		return new RedirectView("/advance/allAdvance");
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
