package com.nem.docms.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection = "Ad_payment")
public class Ad_Payment {
	
	@Id
	private String id;
	private Long amount;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date ef_date;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date ex_date;
	private String status;
	
	public Ad_Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ad_Payment(String id, Long amount, Date ef_date, Date ex_date, String status) {
		super();
		this.id = id;
		this.amount = amount;
		this.ef_date = ef_date;
		this.ex_date = ex_date;
		this.status = status;
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

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Date getEf_date() {
		return ef_date;
	}

	public void setEf_date(Date ef_date) {
		this.ef_date = ef_date;
	}

	public Date getEx_date() {
		return ex_date;
	}

	public void setEx_date(Date ex_date) {
		this.ex_date = ex_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
