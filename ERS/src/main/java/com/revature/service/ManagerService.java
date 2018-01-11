package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.ManagerReimbursementDao;
import com.revature.dao.UserDao;
import com.revature.dto.AllPendingDTO;
import com.revature.dto.AllResolvedDTO;
import com.revature.dto.EmployeeDTO;
import com.revature.dto.ReimbursementRequestDTO;
import com.revature.model.Reimbursement;
import com.revature.model.User;

public class ManagerService {

	public ArrayList<EmployeeDTO> getAllEmployees() {

		UserDao dao = new UserDao();
		List<User> rawEmp = dao.selectAllUser();
		ArrayList<EmployeeDTO> allEmployees = new ArrayList<EmployeeDTO>();

		if (rawEmp != null) {
			for (int i = 0; i < rawEmp.size(); i++) {

				EmployeeDTO emp = new EmployeeDTO(null, null, null, null, null);

				emp.role = rawEmp.get(i).role;
				emp.firstname = rawEmp.get(i).firstname;
				emp.lastname = rawEmp.get(i).lastname;
				emp.username = rawEmp.get(i).username;
				emp.email = rawEmp.get(i).email;

				allEmployees.add(i, emp);
			}
		}
		return allEmployees;
	}

	public ArrayList<AllResolvedDTO> getAllResolved() {

		ManagerReimbursementDao manDao = new ManagerReimbursementDao();
		ArrayList<AllResolvedDTO> allResolved = new ArrayList<AllResolvedDTO>();
		List<Reimbursement> rawRes = manDao.selectAllResolved();

		for (int i = 0; i < rawRes.size(); i++) {

			AllResolvedDTO resolved = new AllResolvedDTO(0, null, null, null, null, null, null, null);

			resolved.amount = rawRes.get(i).amount;
			resolved.type = rawRes.get(i).type;
			resolved.description = rawRes.get(i).description;

			// properly format dates
			String dateRemoveHMSsub = rawRes.get(i).submitted.substring(0, 10);
			String dateYearOnlysub = dateRemoveHMSsub.substring(0, 4);
			String dateRemoveYearsub = dateRemoveHMSsub.substring(5);
			String formattedDatesub = dateRemoveYearsub + "-" + dateYearOnlysub;

			resolved.dateSubmitted = formattedDatesub;

			String dateRemoveHMSres = rawRes.get(i).resolved.substring(0, 10);
			String dateYearOnlyres = dateRemoveHMSres.substring(0, 4);
			String dateRemoveYearres = dateRemoveHMSres.substring(5);
			String formattedDateres = dateRemoveYearres + "-" + dateYearOnlyres;

			resolved.dateResolved = formattedDateres;

			resolved.status = rawRes.get(i).status;
			resolved.username = rawRes.get(i).username;
			resolved.name = rawRes.get(i).firstname + " " + rawRes.get(i).lastname;

			allResolved.add(i, resolved);
		}
		return allResolved;
	}

	public ArrayList<AllPendingDTO> getAllPending() {

		ManagerReimbursementDao manDao = new ManagerReimbursementDao();
		ArrayList<AllPendingDTO> allPending = new ArrayList<AllPendingDTO>();
		List<Reimbursement> rawRes = manDao.selectAllPending();

		for (int i = 0; i < rawRes.size(); i++) {

			AllPendingDTO pend = new AllPendingDTO(0, 0, null, null, null, null, null, null);

			pend.reqid = rawRes.get(i).reqid;
			pend.amount = rawRes.get(i).amount;
			pend.type = rawRes.get(i).type;
			pend.description = rawRes.get(i).description;

			// properly format dates
			String dateRemoveHMS = rawRes.get(i).submitted.substring(0, 10);
			String dateYearOnly = dateRemoveHMS.substring(0, 4);
			String dateRemoveYear = dateRemoveHMS.substring(5);
			String formattedDate = dateRemoveYear + "-" + dateYearOnly;

			pend.dateSubmitted = formattedDate;

			pend.username = rawRes.get(i).username;
			pend.name = rawRes.get(i).firstname + " " + rawRes.get(i).lastname;
			pend.email = rawRes.get(i).email;

			allPending.add(i, pend);
		}
		return allPending;
	}

	public ArrayList<ReimbursementRequestDTO> getAllReimbursementsFromOneEmployee(int userid) {

		ManagerReimbursementDao manDao = new ManagerReimbursementDao();

		List<Reimbursement> rawReim = manDao.selectReimbursementsFromEmployee(userid);
		ArrayList<ReimbursementRequestDTO> allReimbursements = new ArrayList<ReimbursementRequestDTO>();

		for (int i = 0; i < rawReim.size(); i++) {

			ReimbursementRequestDTO reim = new ReimbursementRequestDTO(0, null, null, null, null);

			reim.amount = rawReim.get(i).amount;
			reim.type = rawReim.get(i).type;
			reim.description = rawReim.get(i).description;

			// properly format dates
			String dateRemoveHMS = rawReim.get(i).submitted.substring(0, 10);
			String dateYearOnly = dateRemoveHMS.substring(0, 4);
			String dateRemoveYear = dateRemoveHMS.substring(5);
			String formattedDate = dateRemoveYear + "-" + dateYearOnly;

			reim.dateSubmitted = formattedDate;

			reim.status = rawReim.get(i).status;

			allReimbursements.add(i, reim);
		}
		return allReimbursements;
	}
	
	
	public void setResolution(int reqid, boolean approve, int userid) {
		
		ManagerReimbursementDao manDao = new ManagerReimbursementDao();
		
		manDao.resolveRequest(reqid, approve, userid);
	}
	
}
