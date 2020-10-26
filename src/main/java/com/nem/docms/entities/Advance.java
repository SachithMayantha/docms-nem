package com.nem.docms.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Document(collection = "Ad_payment")
public class Advance {

	@Id
	private String id;
	private String name;
	private Long amount;
	// give a standard format and remove time
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date effective;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date expire;
	private String status;
	private Long remain;

	public Advance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Advance(String id, String name, Long amount, Date effective, Date expire, String status, Long remain) {
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
