package com.nem.docms.controllers;

import com.nem.docms.entities.BidBond;
import com.nem.docms.entities.BidBond2;
import com.nem.docms.servies.BidBondService;
import com.nem.docms.servies.DoUploadService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/bidBond")
public class BidBondController {

    private final BidBondService bidBondService;
    private final DoUploadService doUploadService;

    public BidBondController(BidBondService bidBondService, DoUploadService doUploadService) {
        this.bidBondService = bidBondService;
        this.doUploadService = doUploadService;
    }

    @GetMapping("/allBidBonds")
    public String getAll(Model model, @ModelAttribute("message")String message) {

    	model.addAttribute("message",message);

//		System.out.println("Bidbond List Controller called");
        // get the object list
        List<BidBond> listBidbonds = bidBondService.getAll();

        List<BidBond2> list = new ArrayList<BidBond2>();

        // get the remaining days
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String String1 = java.time.LocalDate.now().toString();
        Long remain;
        int size = listBidbonds.size();
        for (int i = 0; i < size; i++) {
            BidBond2 bid2 = new BidBond2();
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

            String String2 = simpleDateFormat.format(listBidbonds.get(i).getExpire());

            try {
                LocalDate date1 = LocalDate.parse(String1, dtf);
                LocalDate date2 = LocalDate.parse(String2, dtf);
                remain = Duration.between(date1.atStartOfDay(), date2.atStartOfDay()).toDays();

                System.out.println(remain);
                bid2.setRemain(remain);
            } catch (Exception e) {
                System.out.println(e);
            }
            String ef = simpleDateFormat.format(listBidbonds.get(i).getEffective());
            String ex = simpleDateFormat.format(listBidbonds.get(i).getExpire());

            bid2.setId(listBidbonds.get(i).getId());
            bid2.setName(listBidbonds.get(i).getName());
            bid2.setAmount(listBidbonds.get(i).getAmount());
            bid2.setEffective(ef);
            bid2.setExpire(ex);
            bid2.setStatus(listBidbonds.get(i).getStatus());

            list.add(bid2);
            model.addAttribute("list", list);
        }

        return "bidbond";
    }

    @GetMapping("/getBidBond/{id}")
    public BidBond getBidBond(@PathVariable("id") String id) {
        return bidBondService.getBidBond(id);
    }

    @PostMapping("/addBidBond")
    // RequestBody for bind request HTTP body with a domain object
    public RedirectView addBidBond(BidBond2 bid,
								   @RequestParam("document") MultipartFile document, RedirectAttributes modelRedirect) throws ParseException, IOException {
        String title = document.getOriginalFilename();
		System.out.println(document.getResource()+" Resource");
		System.out.println(document.getSize()+" Size");
        String id = bid.getId();
        System.out.println("Document --- " + document.getOriginalFilename() + " --- " + document.getContentType());
        try {
//            doUploadService.addDocument(title, document,id);
            bidBondService.addBidBond(bid);
        } catch (Exception e) {
            e.printStackTrace();
        }
		RedirectView redirectView = new RedirectView("/bidBond/allBidBonds");
//        modelRedirect.addFlashAttribute("message","BidBond Added Successfully");

        return redirectView;
    }

    @PutMapping("/update/{id}")
    public BidBond update(@RequestBody BidBond bid) {
        return bidBondService.update(bid);
    }

    @DeleteMapping("/delete")
    // PathParam for map variable URI path to method call
    public void delete(@RequestParam String id) {
        bidBondService.delete(id);
    }
}
