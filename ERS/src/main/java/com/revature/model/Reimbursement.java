package com.revature.model;

public class Reimbursement {
	
	public int reqid;
	public double amount;
	public String type;
	public String description;
	//public receipt;
	public String submitted;
	public String resolved; // for resolved
	public String status; // for resolved
	public String username;
	public String firstname;
	public String lastname;
	public String email;
	public int statusNum;

	public void setReqid(int reqid) {
		this.reqid = reqid;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setSubmitted(String submitted) {
		this.submitted = submitted;
	}

	public void setResolved(String resolved) {
		this.resolved = resolved;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setStatusNum(int statusNum) {
		this.statusNum = statusNum;
	}

	public int getReqid() {
		return reqid;
	}

	public double getAmount() {
		return amount;
	}

	public String getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}

	public String getSubmitted() {
		return submitted;
	}

	public String getResolved() {
		return resolved;
	}

	public String getStatus() {
		return status;
	}

	public String getUsername() {
		return username;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getEmail() {
		return email;
	}

	public int getStatusNum() {
		return statusNum;
	}


	
	
	public Reimbursement() {

	}

	//PENDING REIMBURSEMENTS FOR MANAGER
	public Reimbursement(int reqid, double amount, String type, String description, String submitted, String username,
			String firstname, String lastname, String email) {
		super();
		this.reqid = reqid;
		this.amount = amount;
		this.type = type;
		this.description = description;
		this.submitted = submitted;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}

	//All REIMBURSEMENTS FROM ONE EMLOYEE FOR MANAGER
	public Reimbursement(int reqid, double amount, String type, String description, String submitted,String status) {
		super();
		this.reqid = reqid;
		this.amount = amount;
		this.type = type;
		this.description = description;
		this.submitted = submitted;
		this.status = status;
	
	}

	//PENDING REIMBURSMENT FOR EMPLOYEE
	public Reimbursement(double amount, String type, String description, String submitted, int statusNum){
		super();
		this.amount = amount;
		this.type = type;
		this.description = description;
		this.submitted = submitted;
		this.statusNum = statusNum;
	}
			
	//RESOLVED REIMBURSEMENTS 
	public Reimbursement(double amount, String type, String description, String submitted, String resolved,
			String status, String username, String firstname, String lastname) {
		super();
		this.amount = amount;
		this.type = type;
		this.description = description;
		this.submitted = submitted;
		this.resolved = resolved;
		this.status = status;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		}

	
}
