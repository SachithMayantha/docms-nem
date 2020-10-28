package com.nem.docms.servies;

import com.nem.docms.entities.Performance;
import com.nem.docms.entities.Performance2;
import com.nem.docms.repositories.PerformanceRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class PerformanceService {

	private final PerformanceRepository performanceRepository;

	public PerformanceService(PerformanceRepository performanceRepository) {
		this.performanceRepository = performanceRepository;
	}

	public List<Performance> getAll() {
		// TODO Auto-generated method stub
		return performanceRepository.findAll();
	}

	public Performance getPerformance(String id) {
		try{
		return performanceRepository.findById(id).get();
	}catch (Exception e){
		e.printStackTrace();
		return new Performance();
		}
	}

	public Performance addPerformance(Performance2 per) throws ParseException {
		try{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Performance per1 = new Performance();
		per1.setId(per.getId());
		per1.setName(per.getName());
		per1.setAmount(per.getAmount());
		per1.setEffective(simpleDateFormat.parse(per.getEffective()));
		per1.setExpire(simpleDateFormat.parse(per.getExpire()));
		per1.setRemain(per.getRemain());
		per1.setStatus(per.getStatus());

		return performanceRepository.insert(per1);
	}catch (Exception e){
			e.printStackTrace();
			return new Performance();
		}}

	public Performance update(Performance per) {
		// TODO Auto-generated method stub
		return performanceRepository.save(per);
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
		performanceRepository.deleteById(id);
	}
}
