package com.nem.docms.servies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nem.docms.entities.Ad_Payment;
import com.nem.docms.repositories.Ad_PaymentRepository;

@Service
public interface Ad_PaymentService {
	
	@Autowired
	Ad_PaymentRepository ad_PaymentRepository;

	public List<Ad_Payment> getAll() {
		// TODO Auto-generated method stub
		return ad_PaymentRepository.findAll();
	}
	
	public Ad_Payment getAd_Payment(String id) {
		// TODO Auto-generated method stub
		return ad_PaymentRepository.findById(id).get();
	}

	public Ad_Payment addAd_Payment(Ad_Payment ad) {
		// TODO Auto-generated method stub
		return ad_PaymentRepository.insert(ad);
	}

	public Ad_Payment update(Ad_Payment ad) {
		// TODO Auto-generated method stub
		return ad_PaymentRepository.save(ad);
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
		adRepository.deleteById(id);
	}

}
