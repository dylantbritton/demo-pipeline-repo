package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myPendingView")
public class MyPendingViewServlet extends HttpServlet {
	
	private static final long serialVersionUID = -2183572965815947003L;

	public MyPendingViewServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("employeeViews/viewMyPending.html").forward(request, response);

	}

	
}
