package com.nem.docms.servies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nem.docms.entities.BidBond;
import com.nem.docms.repositories.BidBondRepository;

@Service
public class BidBondService {
	
	@Autowired
	BidBondRepository bidBondRepository;
	
	public List<BidBond> getAll() {
		// TODO Auto-generated method stub
		return bidBondRepository.findAll();
	}
	
	public BidBond getBidBond(String id) {
		// TODO Auto-generated method stub
		return bidBondRepository.findById(id).get();
	}

	public BidBond addBidBond(BidBond bid) {
		// TODO Auto-generated method stub
		return bidBondRepository.insert(bid);
	}

	public BidBond update(BidBond bid) {
		// TODO Auto-generated method stub
		return bidBondRepository.save(bid);
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
		bidBondRepository.deleteById(id);
	}

}
