package com.nem.docms.servies;

import com.nem.docms.entities.BidBond;
import com.nem.docms.entities.BidBond2;
import com.nem.docms.repositories.BidBondRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class BidBondService {

	private final BidBondRepository bidBondRepository;

	public BidBondService(BidBondRepository bidBondRepository) {
		this.bidBondRepository = bidBondRepository;
	}

	public List<BidBond> getAll() {
//		System.out.println("service bid bond list called ");
		return bidBondRepository.findAll();
	}

	public BidBond getBidBond(String id) {
		// TODO Auto-generated method stub
		return bidBondRepository.findById(id).get();
	}

	public BidBond addBidBond(BidBond2 bid) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		BidBond bid1 = new BidBond();
		bid1.setId(bid.getId());
		bid1.setName(bid.getName());
		bid1.setAmount(bid.getAmount());
		bid1.setEffective(simpleDateFormat.parse(bid.getEffective()));
		bid1.setExpire(simpleDateFormat.parse(bid.getExpire()));
		bid1.setRemain(bid.getRemain());
		bid1.setStatus(bid.getStatus());
		// TODO Auto-generated method stub

		return bidBondRepository.insert(bid1);
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
