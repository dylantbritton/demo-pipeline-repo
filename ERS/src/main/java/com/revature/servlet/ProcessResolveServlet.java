package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.User;
import com.revature.service.ManagerService;

@WebServlet("/processResolve")
public class ProcessResolveServlet extends HttpServlet{
	
	private static final long serialVersionUID = 6969057337292037044L;

	
	public ProcessResolveServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//request.getRequestDispatcher("managerViews/confirmResolve.html").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String resolution = request.getParameter("setResolve");
		int reqid = Integer.parseInt(request.getParameter("selectedResolve"));
		
		HttpSession session = request.getSession();
		User clientUser = (User)session.getAttribute("user");

		ManagerService manSer = new ManagerService();
		
		
		if(resolution.equals("approve")) {
			
			manSer.setResolution(reqid, true, clientUser.userid);
			
		} else if(resolution.equals("reject")) {

			manSer.setResolution(reqid, false, clientUser.userid);
			
		}
		AllPendingViewServlet pendView = new AllPendingViewServlet();
		doGet(request, response);
	}
}
