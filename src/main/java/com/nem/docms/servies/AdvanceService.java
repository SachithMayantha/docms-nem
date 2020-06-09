package com.nem.docms.servies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nem.docms.entities.Advance;
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

	public Advance addAdvance(Advance ad) {
		// TODO Auto-generated method stub
		return advanceRepository.insert(ad);
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
