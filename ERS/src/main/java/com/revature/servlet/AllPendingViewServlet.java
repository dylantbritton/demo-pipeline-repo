package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewAllPending")

public class AllPendingViewServlet extends HttpServlet{

	private static final long serialVersionUID = -6131341725704515892L;
	
	public AllPendingViewServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("managerViews/viewAllPending.html").forward(request, response);
	}

}
