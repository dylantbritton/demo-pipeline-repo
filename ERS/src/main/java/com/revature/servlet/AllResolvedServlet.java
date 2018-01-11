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

@WebServlet("/retrieveAllResolved")

public class AllResolvedServlet extends HttpServlet {
	
	private static final long serialVersionUID = -5511195184024715346L;

	public AllResolvedServlet(){
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ManagerService manSer = new ManagerService();
		
		ArrayList<AllResolvedDTO> allResolved = manSer.getAllResolved();
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		String resToJson = objectMapper.writeValueAsString(allResolved);
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		
		out.write(resToJson);
	}

}
