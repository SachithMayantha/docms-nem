package com.nem.docms.controllers;

import com.nem.docms.entities.Performance;
import com.nem.docms.entities.Performance2;
import com.nem.docms.servies.PerformanceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/performance")
public class PerformanceController {

	private final PerformanceService performanceService;

	public PerformanceController(PerformanceService performanceService) {
		this.performanceService = performanceService;
	}

	@GetMapping("/allPerformance")
	public String getAll(Model model) {

//		System.out.println("Advance List Controller called");
		List<Performance> listPerformance = performanceService.getAll();
		List<Performance2> list = new ArrayList<Performance2>();
		// get the remaining days
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String String1 = java.time.LocalDate.now().toString();
		Long remain;
		int size = listPerformance.size();
		for (int i = 0; i < size; i++) {
			Performance2 per2 = new Performance2();
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

			String String2 = simpleDateFormat.format(listPerformance.get(i).getExpire());
			try {

				LocalDate date1 = LocalDate.parse(String1, dtf);
				LocalDate date2 = LocalDate.parse(String2, dtf);
				remain = Duration.between(date1.atStartOfDay(), date2.atStartOfDay()).toDays();

//				System.out.println(remain);
				per2.setRemain(remain);

			} catch (Exception e) {
				System.out.println(e);
			}
			String ef = simpleDateFormat.format(listPerformance.get(i).getEffective());
			String ex = simpleDateFormat.format(listPerformance.get(i).getExpire());

			per2.setId(listPerformance.get(i).getId());
			per2.setName(listPerformance.get(i).getName());
			per2.setAmount(listPerformance.get(i).getAmount());
			per2.setEffective(ef);
			per2.setExpire(ex);
			per2.setStatus(listPerformance.get(i).getStatus());

			list.add(per2);
			model.addAttribute("list", list);
		}
		return "performance";
	}

	@GetMapping("/getPerformance/{id}")
	public Performance getPerformance(@PathVariable("id") String id) {
		return performanceService.getPerformance(id);
	}

	@PostMapping("/addPerformance")
	// RequestBody for bind request HTTP body with a domain object
	public RedirectView addPerformance(Performance2 per) throws ParseException {
//		System.out.println("Performance controller addPerformance()");
		performanceService.addPerformance(per);
		return new RedirectView("/performance/allPerformance");
	}

	@PutMapping("/update/{id}")
	public Performance update(@RequestBody Performance per) {
		return performanceService.update(per);
	}

	@DeleteMapping("/delete")
	// PathParam for map variable URI path to method call
	public void delete(@RequestParam String id) {
		performanceService.delete(id);
	}

}
