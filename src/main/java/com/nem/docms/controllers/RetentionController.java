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

import com.nem.docms.entities.Retention;
import com.nem.docms.entities.Retention2;
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
		//get the remaining days
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String String1 = java.time.LocalDate.now().toString();
				Long remain;
				for(int i=0;i<listRetention.size();i++) {
					String pattern = "yyyy-MM-dd";
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
				
					String String2 =simpleDateFormat.format(listRetention.get(i).getExpire());
					try {
						
					LocalDate date1 = LocalDate.parse(String1, dtf);
				    LocalDate date2 = LocalDate.parse(String2, dtf);
				    remain =  Duration.between(date1.atStartOfDay(), date2.atStartOfDay()).toDays();

				    System.out.println(remain);
				    listRetention.get(i).setRemain(remain);
				  
					}catch (Exception e) {
						System.out.println(e);
					}
					
		model.addAttribute("listRetention",listRetention);
				}
		return "retention";
	}
	
	@GetMapping("/getRetention/{id}")
	public Retention getRetention(@PathVariable("id") String id) {
		return retentionService.getRetention(id);
	}
	
	@PostMapping("/addRetention")
	//RequestBody for bind request HTTP body with a domain object 
		public RedirectView  addRetention(Retention2 ret) throws ParseException{
			System.out.println("Retention controller addRetention()");
			retentionService.addRetention(ret);
			return new RedirectView("/retention/allRetention");
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
