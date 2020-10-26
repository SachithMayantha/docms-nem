package com.nem.docms.controllers;

import com.nem.docms.entities.Retention;
import com.nem.docms.entities.Retention2;
import com.nem.docms.servies.RetentionService;
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
@RequestMapping("/retention")
public class RetentionController {


	private final RetentionService retentionService;

	public RetentionController(RetentionService retentionService) {
		this.retentionService = retentionService;
	}

	@GetMapping("/allRetention")
	public String getAll(Model model) {

//		System.out.println("Retention List Controller called");
		List<Retention> listRetention = retentionService.getAll();
		List<Retention2> list = new ArrayList<Retention2>();
		// get the remaining days
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String String1 = java.time.LocalDate.now().toString();
		Long remain;
		int size = listRetention.size();
		for (int i = 0; i < size; i++) {
			Retention2 ret2 = new Retention2();
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

			String String2 = simpleDateFormat.format(listRetention.get(i).getExpire());
			try {

				LocalDate date1 = LocalDate.parse(String1, dtf);
				LocalDate date2 = LocalDate.parse(String2, dtf);
				remain = Duration.between(date1.atStartOfDay(), date2.atStartOfDay()).toDays();

//				System.out.println(remain);
				ret2.setRemain(remain);

			} catch (Exception e) {
				System.out.println(e);
			}

			String ef = simpleDateFormat.format(listRetention.get(i).getEffective());
			String ex = simpleDateFormat.format(listRetention.get(i).getExpire());

			ret2.setId(listRetention.get(i).getId());
			ret2.setName(listRetention.get(i).getName());
			ret2.setAmount(listRetention.get(i).getAmount());
			ret2.setEffective(ef);
			ret2.setExpire(ex);
			ret2.setStatus(listRetention.get(i).getStatus());

			list.add(ret2);
			model.addAttribute("list", list);
		}
		return "retention";
	}

	@GetMapping("/getRetention/{id}")
	public Retention getRetention(@PathVariable("id") String id) {
		return retentionService.getRetention(id);
	}

	@PostMapping("/addRetention")
	// RequestBody for bind request HTTP body with a domain object
	public RedirectView addRetention(Retention2 ret) throws ParseException {
//		System.out.println("Retention controller addRetention()");
		retentionService.addRetention(ret);
		return new RedirectView("/retention/allRetention");
	}

	@PutMapping("/update/{id}")
	public Retention update(@RequestBody Retention ret) {
		return retentionService.update(ret);
	}

	@DeleteMapping("/delete")
	// PathParam for map variable URI path to method call
	public void delete(@RequestParam String id) {
		retentionService.delete(id);
	}

}
