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
        try {
            return bidBondRepository.findById(id).get();
        } catch (Exception e) {
            e.printStackTrace();
            return new BidBond();
        }
    }

    public BidBond addBidBond(BidBond2 bid) throws ParseException {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            BidBond bid1 = new BidBond();
            bid1.setId(bid.getId());
            bid1.setName(bid.getName());
            bid1.setAmount(bid.getAmount());
            bid1.setEffective(simpleDateFormat.parse(bid.getEffective()));
            bid1.setExpire(simpleDateFormat.parse(bid.getExpire()));
            bid1.setRemain(bid.getRemain());
            bid1.setStatus(bid.getStatus());

            return bidBondRepository.insert(bid1);
        } catch (Exception e) {
            e.printStackTrace();
            return new BidBond();
        }
    }

    public BidBond update(BidBond bid) {
        try {
            return bidBondRepository.save(bid);
        } catch (Exception e) {
            e.printStackTrace();
            return bid;
        }
    }

    public void delete(String id) {
        try {
            bidBondRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
