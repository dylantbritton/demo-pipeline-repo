package com.revature.dao;

public class MasterDao {
	
	static final String url = "jdbc:oracle:thin:@usfdb.ceixeca2f0dl.us-east-2.rds.amazonaws.com:1521:orcl";
	static final String masterUsername = "user01";
	static final String masterPassword = "pass1234";
	
	static{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
