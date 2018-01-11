package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/employeeListView")
public class AllEmployeeViewServlet extends HttpServlet{

	private static final long serialVersionUID = 5519507457240432344L;

	public AllEmployeeViewServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("managerViews/viewEmployees.html").forward(request, response);
	}
}
