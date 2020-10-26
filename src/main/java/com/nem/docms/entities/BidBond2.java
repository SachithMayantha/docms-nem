package com.nem.docms.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.NumberFormat;

@Getter
@Setter
@Document(collection = "Bid_bond")
public class BidBond2 {

	@Id
	private String id;
	private String name;
	@NumberFormat(style = NumberFormat.Style.CURRENCY)
	private double amount;
	private String effective;
	private String expire;
	private String status;
	private long remain;

	public BidBond2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BidBond2(String id,String name, double amount, String effective, String expire, String status, long remain) {
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
