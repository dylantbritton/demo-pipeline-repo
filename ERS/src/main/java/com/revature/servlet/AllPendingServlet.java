package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dto.AllPendingDTO;
import com.revature.service.ManagerService;

@WebServlet("/retrieveAllPending")

public class AllPendingServlet extends HttpServlet{

	private static final long serialVersionUID = 8742540279202028594L;

	public AllPendingServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ManagerService manSer = new ManagerService();
		
		ArrayList<AllPendingDTO> allPending = manSer.getAllPending();
		
		ObjectMapper objectMapper = new ObjectMapper();
		String pendToJson = objectMapper.writeValueAsString(allPending);
		 
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		
		out.write(pendToJson);
	}
}
