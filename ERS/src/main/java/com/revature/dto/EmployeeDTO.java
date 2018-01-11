package com.revature.dto;

public class EmployeeDTO {

	public String role;
	public String firstname;
	public String lastname;
	public String username;
	public String email;
	
	
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public EmployeeDTO(String role, String firstname, String lastname, String username, String email) {
		super();
		this.role = role;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
	}
	
	
	
}
