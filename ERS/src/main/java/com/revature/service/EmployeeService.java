package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.EmployeeReimbursementDao;
import com.revature.dto.MyPendingDTO;
import com.revature.dto.MyResolvedDTO;
import com.revature.model.Reimbursement;
import com.revature.model.User;

public class EmployeeService {

	EmployeeReimbursementDao empDao = new EmployeeReimbursementDao();

	public void submitRequest(User clientUser, Reimbursement request) {
			int reqType;
			if (request.type.equals("hotel")) {
				reqType = 1;
			} else if (request.type.equals("food")) {
				reqType = 2;
			} else if (request.type.equals("transportation")) {
				reqType = 3;
			} else
				reqType = 0;
			empDao.submitNewRequest(request.amount, request.description, clientUser.userid, reqType);
	}
	
	//Convert personal pending result list from DAO into array list of DTO
	public List<MyPendingDTO> retreiveMyPendingList(User clientUser) {
		
		List<Reimbursement> rawPend = empDao.selectPendingFromEmployee(clientUser.userid);
		
		List<MyPendingDTO> myPendings = new ArrayList<>(rawPend.size());
		
		for(int i=0;i<rawPend.size();i++)
		{
			MyPendingDTO myPend = new MyPendingDTO(0, null, null, null);

			myPend.amount = rawPend.get(i).amount;
			myPend.type = rawPend.get(i).type;
			myPend.description = rawPend.get(i).description;
			 
			//properly format date
			String dateRemoveHMS = rawPend.get(i).submitted.substring(0, 10);
			String dateYearOnly = dateRemoveHMS.substring(0, 4);
			String dateRemoveYear = dateRemoveHMS.substring(5);
			String formattedDate = dateRemoveYear + "-" + dateYearOnly;
			
			myPend.dateSubmitted = formattedDate;
					
			myPendings.add(i, myPend);
		}
	
		return myPendings;
	}
	
	//Convert personal resolved result list from DAO into array list of DTO

	public List<MyResolvedDTO> retreiveMyResolvedList(User clientUser) {

		List<Reimbursement> rawRes = empDao.selectResolvedFromEmployee(clientUser.userid);
		
		List<MyResolvedDTO> myResolved = new ArrayList<>(rawRes.size());
		
		for(int i=0;i<rawRes.size();i++)
		{
			MyResolvedDTO myRes = new MyResolvedDTO(0, null, null, null, null);

			myRes.amount = rawRes.get(i).amount;
			myRes.type = rawRes.get(i).type;
			myRes.description = rawRes.get(i).description;
			 
			//properly format date
			String dateRemoveHMS = rawRes.get(i).submitted.substring(0, 10);
			String dateYearOnly = dateRemoveHMS.substring(0, 4);
			String dateRemoveYear = dateRemoveHMS.substring(5);
			String formattedDate = dateRemoveYear + "-" + dateYearOnly;
			
			myRes.dateSubmitted = formattedDate;
			myRes.status = rawRes.get(i).status;
					
			myResolved.add(i, myRes);
		}
		return myResolved;
	}	
	
	
}
