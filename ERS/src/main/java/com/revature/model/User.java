package com.revature.model;

public class User {
	public int userid;
	public String firstname;
	public String lastname;
	public String username;
	public String email;
	public String role;
	public String password;
	
	public User() {
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//For returning list of users, no password needed
	public User(int userid, String firstname, String lastname, String username, String email, String role) {
		super();
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
		this.role = role;
	}

	//for validating login, password needed
	public User(int userid, String firstname, String lastname, String username, String password, String email,  String role) {
		super();
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", firstname=" + firstname + ", lastname=" + lastname + ", username="
				+ username + ", password = " + password + ", email=" + email + ", role=" + role + "]";
	}
	
	
	
}
