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
import com.revature.dto.MyResolvedDTO;
import com.revature.model.User;
import com.revature.service.EmployeeService;

@WebServlet("/getMyResolved")
public class MyResolvedServlet extends HttpServlet {

	private static final long serialVersionUID = -1293618459188284929L;

	public MyResolvedServlet(){
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		EmployeeService empSer = new EmployeeService();
		HttpSession session = request.getSession();
		
		User clientUser = (User)session.getAttribute("user");
		List<MyResolvedDTO> myPending = empSer.retreiveMyResolvedList(clientUser);

		if(myPending != null) {
			
			ObjectMapper objectMapper = new ObjectMapper();
			
			String resolvedToJson = objectMapper.writeValueAsString(myPending);
			
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			out.write(resolvedToJson);
		}
	}
}
