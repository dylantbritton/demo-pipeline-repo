package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myResolvedView")
public class MyResolvedViewServlet extends HttpServlet {
	
	private static final long serialVersionUID = -99545829278419969L;

	public MyResolvedViewServlet(){
		super();
	}
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		request.getRequestDispatcher("employeeViews/viewMyResolved.html").forward(request, response);
	}

}
