package com.nem.docms.servies;

import com.nem.docms.entities.Advance;
import com.nem.docms.entities.Advance2;
import com.nem.docms.repositories.AdvanceRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class AdvanceService {

    //make dependency immutable by final
    private final AdvanceRepository advanceRepository;

    //constructor dependency injection
    public AdvanceService(AdvanceRepository advanceRepository) {
        this.advanceRepository = advanceRepository;
    }

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
        try {
            ad1.setId(ad.getId());
            ad1.setName(ad.getName());
            ad1.setAmount(ad.getAmount());
            ad1.setEffective(simpleDateFormat.parse(ad.getEffective()));
            ad1.setExpire(simpleDateFormat.parse(ad.getExpire()));
            ad1.setRemain(ad.getRemain());
            ad1.setStatus(ad.getStatus());
            return advanceRepository.insert(ad1);
        }catch (Exception e){
            return ad1;
        }
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
