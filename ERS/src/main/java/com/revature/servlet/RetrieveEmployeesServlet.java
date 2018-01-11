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
import com.revature.dto.EmployeeDTO;
import com.revature.service.ManagerService;

@WebServlet("/retrieveEmployees")
public class RetrieveEmployeesServlet extends HttpServlet {


	private static final long serialVersionUID = 5732448286507591960L;
	
	public RetrieveEmployeesServlet() {
		super();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ManagerService manSer = new ManagerService();
		ArrayList<EmployeeDTO> employeeList = manSer.getAllEmployees();

		if(employeeList != null) {

			ObjectMapper objectMapper = new ObjectMapper();
			
			String empToJson = objectMapper.writeValueAsString(employeeList);
			
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			out.write(empToJson);
		}
	}
}
