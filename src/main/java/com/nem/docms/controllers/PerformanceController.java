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

import com.nem.docms.entities.Performance;
import com.nem.docms.entities.Performance2;
import com.nem.docms.servies.PerformanceService;

@Controller
@RequestMapping("/performance")
public class PerformanceController {
	
	@Autowired
	PerformanceService performanceService;
	
	@GetMapping("/allPerformance")
	public String getAll(Model model){
		
		System.out.println("Advance List Controller called");
		List<Performance> listPerformance = performanceService.getAll();
		//get the remaining days
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String String1 = java.time.LocalDate.now().toString();
				Long remain;
				for(int i=0;i<listPerformance.size();i++) {
					String pattern = "yyyy-MM-dd";
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
				
					String String2 =simpleDateFormat.format(listPerformance.get(i).getExpire());
					try {
						
					LocalDate date1 = LocalDate.parse(String1, dtf);
				    LocalDate date2 = LocalDate.parse(String2, dtf);
				    remain =  Duration.between(date1.atStartOfDay(), date2.atStartOfDay()).toDays();

				    System.out.println(remain);
				    listPerformance.get(i).setRemain(remain);
				  
					}catch (Exception e) {
						System.out.println(e);
					}
		model.addAttribute("listPerformance",listPerformance);
	}
		return "performance";
	}
	@GetMapping("/getPerformance/{id}")
	public Performance getPerformance(@PathVariable("id") String id) {
		return performanceService.getPerformance(id);
	}
	
	@PostMapping("/addPerformance")
	//RequestBody for bind request HTTP body with a domain object 
	public RedirectView  addPerformance(Performance2 per) throws ParseException{
		System.out.println("Performance controller addPerformance()");
		performanceService.addPerformance(per);
		return new RedirectView("/performance/allPerformance");
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
