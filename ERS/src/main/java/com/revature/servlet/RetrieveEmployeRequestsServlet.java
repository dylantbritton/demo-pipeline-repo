package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/retrieveEmpReq")

public class RetrieveEmployeRequestsServlet extends HttpServlet{

	private static final long serialVersionUID = -8140247338531551202L;

	
	
	RetrieveEmployeRequestsServlet(){
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		//get username from JS
		
		//
	
	}
}