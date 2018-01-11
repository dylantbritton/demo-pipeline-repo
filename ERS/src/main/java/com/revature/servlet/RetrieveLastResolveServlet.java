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
import com.revature.dto.AllResolvedDTO;
import com.revature.service.ManagerService;

@WebServlet("/retrieveLastResolve")
public class RetrieveLastResolveServlet extends HttpServlet {

	private static final long serialVersionUID = 3230540086056195300L;

	
	public RetrieveLastResolveServlet() {
		super();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ManagerService manSer = new ManagerService();
		
		ArrayList<AllResolvedDTO> allResolved = manSer.getAllResolved();
		
		AllResolvedDTO lastResolved = allResolved.get(allResolved.size() - 1);
		ObjectMapper objectMapper = new ObjectMapper();
		
		String resToJson = objectMapper.writeValueAsString(lastResolved);
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		
		out.write(resToJson);
	}
	
}
