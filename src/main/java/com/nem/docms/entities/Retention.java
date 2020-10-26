package com.nem.docms.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Document(collection = "Retention")
public class Retention {
	
	@Id
	private String id;
	private String name;
	private Long amount;
	//give a standard format and remove time
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date effective;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date expire;
	private Long remain;
	private String status;
	
	public Retention() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Retention(String id, String name, Long amount, Date effective, Date expire, Long remain, String status) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.effective = effective;
		this.expire = expire;
		this.remain = remain;
		this.status = status;
	}
}
