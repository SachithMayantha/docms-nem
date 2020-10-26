package com.nem.docms.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Performance2 {
	@Id
	private String id;
	private String name;
	private Long amount;
	private String effective;
	private String expire;
	private String status;
	private long remain;

	public Performance2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Performance2(String id,String name, long amount, String effective, String expire, String status, long remain) {
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
