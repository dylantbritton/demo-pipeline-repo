package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.User;


@WebServlet("/navbar")
public class NavbarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public NavbarServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User clientUser = (User)session.getAttribute("user");
		
		if (clientUser.role.equals("Employee")) {
			
			request.getRequestDispatcher("employeenavbar.html").forward(request, response);

		} else if (clientUser.role.equals("Manager")) {
			
			request.getRequestDispatcher("managernavbar.html").forward(request, response);
		}
		
	}
}
