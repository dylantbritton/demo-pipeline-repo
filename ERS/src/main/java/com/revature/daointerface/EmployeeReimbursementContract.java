package com.revature.daointerface;

import java.util.List;

import com.revature.model.Reimbursement;

public interface EmployeeReimbursementContract {
	
	public void submitNewRequest(double amount, String description, int authorid, int type);
	public List<Reimbursement> selectPendingFromEmployee(int empid);
	public List<Reimbursement> selectResolvedFromEmployee(int empid);

}
