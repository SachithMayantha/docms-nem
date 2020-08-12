package com.nem.docms.servies;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nem.docms.entities.Advance;
import com.nem.docms.entities.Advance2;
import com.nem.docms.repositories.AdvanceRepository;

@Service
public class AdvanceService {

	@Autowired
	AdvanceRepository advanceRepository;

	public List<Advance> getAll() {
		// TODO Auto-generated method stub
		return advanceRepository.findAll();
	}

	public Advance getAdvance(String id) {
		// TODO Auto-generated method stub
		return advanceRepository.findById(id).get();
	}

	public Advance addAdvance(Advance2 ad) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Advance ad1 = new Advance();
		ad1.setId(ad.getId());
		ad1.setName(ad.getName());
		ad1.setAmount(ad.getAmount());
		ad1.setEffective(simpleDateFormat.parse(ad.getEffective()));
		ad1.setExpire(simpleDateFormat.parse(ad.getExpire()));
		ad1.setRemain(ad.getRemain());
		ad1.setStatus(ad.getStatus());
		// TODO Auto-generated method stub

		return advanceRepository.insert(ad1);
	}

	public Advance update(Advance ad) {
		// TODO Auto-generated method stub
		return advanceRepository.save(ad);
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
		advanceRepository.deleteById(id);
	}

}
