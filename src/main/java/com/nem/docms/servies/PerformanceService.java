package com.nem.docms.servies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nem.docms.entities.Performance;
import com.nem.docms.repositories.PerformanceRepository;

@Service
public class PerformanceService {
	
	@Autowired
	PerformanceRepository performanceRepository;

	public List<Performance> getAll() {
		// TODO Auto-generated method stub
		return performanceRepository.findAll();
	}
	
	public Performance getPerformance(String id) {
		// TODO Auto-generated method stub
		return performanceRepository.findById(id).get();
	}

	public Performance addPerformance(Performance per) {
		// TODO Auto-generated method stub
		return performanceRepository.insert(per);
	}

	public Performance update(Performance per) {
		// TODO Auto-generated method stub
		return performanceRepository.save(per);
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
		performanceRepository.deleteById(id);
	}
}
