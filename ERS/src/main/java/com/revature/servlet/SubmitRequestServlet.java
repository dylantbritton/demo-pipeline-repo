package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/submitRequest")
public class SubmitRequestServlet extends HttpServlet{
	  
	
	private static final long serialVersionUID = 1L;


		public SubmitRequestServlet() {
	        super();
	    }

		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.getRequestDispatcher("employeeViews/submitRequest.html").forward(request, response);
		}
}
