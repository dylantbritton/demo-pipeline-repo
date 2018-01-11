package com.revature.dto;

public class AllPendingDTO {

	public int reqid;
	public double amount;
	public String type;
	public String description;
	public String dateSubmitted;
	public String username;
	public String name;
	public String email;
	
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDateSubmitted() {
		return dateSubmitted;
	}
	public void setDateSubmitted(String dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getReqid() {
		return reqid;
	}
	public void setReqid(int reqid) {
		this.reqid = reqid;
	}
	public AllPendingDTO(int reqid, double amount, String type, String description, String dateSubmitted, String username,
			String name, String email) {
		super();
		this.reqid = reqid;
		this.amount = amount;
		this.type = type;
		this.description = description;
		this.dateSubmitted = dateSubmitted;
		this.username = username;
		this.name = name;
		this.email = email;
	}
	
	
}
