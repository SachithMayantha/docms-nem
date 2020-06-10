package com.nem.docms.servies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nem.docms.entities.Retention;
import com.nem.docms.repositories.RetentionRepository;

@Service
public class RetentionService {
	
	@Autowired
	RetentionRepository retentionRepository;
	
	public List<Retention> getAll() {
		// TODO Auto-generated method stub
		return retentionRepository.findAll();
	}
	
	public Retention getRetention(String id) {
		// TODO Auto-generated method stub
		return retentionRepository.findById(id).get();
	}

	public Retention addRetention(Retention ad) {
		// TODO Auto-generated method stub
		return retentionRepository.insert(ad);
	}

	public Retention update(Retention ad) {
		// TODO Auto-generated method stub
		return retentionRepository.save(ad);
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
		retentionRepository.deleteById(id);
	}

}
