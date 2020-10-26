package com.nem.docms.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.NumberFormat;

import java.util.Date;

@Getter
@Setter
@Document(collection = "Bid_bond")
public class BidBond {

	@Id
	private String id;
	private String name;
	@NumberFormat(style = NumberFormat.Style.CURRENCY)
	private double amount;
	//give a standard format and remove time
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date effective;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date expire;
	private String status;
	private long remain;

	public BidBond() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BidBond(String id,String name, double amount, Date effective, Date expire, String status, long remain) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.effective = effective;
		this.expire = expire;
		this.status = status;
		this.remain = remain;
	}
}
