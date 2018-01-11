package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.service.EmployeeService;

@WebServlet("/processRequest")
public class ProcessRequestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ProcessRequestServlet() {
		super();
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		double amount = Double.parseDouble(request.getParameter("amount"));
		String type = request.getParameter("type");
		String description = request.getParameter("description");

		EmployeeService empSer = new EmployeeService();
		HttpSession session = request.getSession();
		User clientUser = (User)session.getAttribute("user");
		
		Reimbursement reimReq = new Reimbursement();
		reimReq.setAmount(amount);
		reimReq.setType(type);
		reimReq.setDescription(description);
		
		empSer.submitRequest(clientUser, reimReq);
		
		request.getRequestDispatcher("login.html");
		
	}
}
