package com.revature.daointerface;

import java.util.List;

import com.revature.model.Reimbursement;

public interface ManagerReimbursementContract{
	public List<Reimbursement> selectAllPending();
	public List<Reimbursement> selectReimbursementsFromEmployee(int empid);
	public List<Reimbursement> selectAllResolved();
	public void resolveRequest(int reqid, boolean approve, int userid);
}
