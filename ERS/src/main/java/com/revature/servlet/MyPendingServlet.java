package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dto.MyPendingDTO;
import com.revature.model.User;
import com.revature.service.EmployeeService;

@WebServlet("/getMyPending")
public class MyPendingServlet extends HttpServlet {

	
	private static final long serialVersionUID = 8143308344651742578L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmployeeService empSer = new EmployeeService();
		HttpSession session = request.getSession();
		
		User clientUser = (User)session.getAttribute("user");
		List<MyPendingDTO> myPending = empSer.retreiveMyPendingList(clientUser);
		
		
		if(myPending != null) {
		ObjectMapper jackson = new ObjectMapper();
			
			String pendingToJson = jackson.writeValueAsString(myPending);
			
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			out.write(pendingToJson);
		}
	}

}
