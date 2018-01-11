package com.revature.dto;

public class MyPendingDTO {
	public double amount;
	public String type;
	public String description;
	public String dateSubmitted;
	
	
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
	public MyPendingDTO(double amount, String type, String description, String dateSubmitted) {
		this.amount = amount;
		this.type = type;
		this.description = description;
		this.dateSubmitted = dateSubmitted;
	}
	@Override
	public String toString() {
		return "MyPendingDTO [amount=" + amount + ", type=" + type + ", description=" + description + ", dateSubmitted="
				+ dateSubmitted + "]";
	}
	
	
	
	
}


