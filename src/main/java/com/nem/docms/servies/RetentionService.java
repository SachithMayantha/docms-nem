package com.nem.docms.servies;

import com.nem.docms.entities.Retention;
import com.nem.docms.entities.Retention2;
import com.nem.docms.repositories.RetentionRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class RetentionService {

	private final RetentionRepository retentionRepository;

	public RetentionService(RetentionRepository retentionRepository) {
		this.retentionRepository = retentionRepository;
	}

	public List<Retention> getAll() {
		// TODO Auto-generated method stub
		return retentionRepository.findAll();
	}

	public Retention getRetention(String id) {
		// TODO Auto-generated method stub
		return retentionRepository.findById(id).get();
	}

	public Retention addRetention(Retention2 ret) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Retention ret1 = new Retention();
		ret1.setId(ret.getId());
		ret1.setName(ret.getName());
		ret1.setAmount(ret.getAmount());
		ret1.setEffective(simpleDateFormat.parse(ret.getEffective()));
		ret1.setExpire(simpleDateFormat.parse(ret.getExpire()));
		ret1.setRemain(ret.getRemain());
		ret1.setStatus(ret.getStatus());
		// TODO Auto-generated method stub

		return retentionRepository.insert(ret1);
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
