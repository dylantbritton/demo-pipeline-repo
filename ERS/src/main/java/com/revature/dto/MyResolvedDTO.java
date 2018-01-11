package com.revature.dto;

public class MyResolvedDTO {

	public double amount;
	public String type;
	public String description;
	public String dateSubmitted;
	public String status;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public MyResolvedDTO(double amount, String type, String description, String dateSubmitted, String status) {
		super();
		this.amount = amount;
		this.type = type;
		this.description = description;
		this.dateSubmitted = dateSubmitted;
		this.status = status;
	}
	@Override
	public String toString() {
		return "MyResolvedDTO [amount=" + amount + ", type=" + type + ", description=" + description
				+ ", dateSubmitted=" + dateSubmitted + ", status=" + status + "]";
	}
	
	
	
}
