package com.nem.docms.entities;

import org.springframework.data.annotation.Id;

public class Advance2 {
	@Id
	private String id;
	private String name;
	private Long amount;
	private String effective;
	private String expire;
	private String status;
	private long remain;
	
	public long getRemain() {
		return remain;
	}

	public void setRemain(long remain) {
		this.remain = remain;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Advance2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Advance2(String id,String name, long amount, String effective, String expire, String status, long remain) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.effective = effective;
		this.expire = expire;
		this.status = status;
		this.remain = remain;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getEffective() {
		return effective;
	}

	public void setEffective(String effective) {
		this.effective = effective;
	}

	public String getExpire() {
		return expire;
	}

	public void setExpire(String expire) {
		this.expire = expire;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}