package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.daointerface.ManagerReimbursementContract;
import com.revature.model.Reimbursement;

public class ManagerReimbursementDao extends MasterDao implements ManagerReimbursementContract {

	//VIEW ALL PENDING REQUESTS
	@Override
	public List<Reimbursement> selectAllPending() {

		List<Reimbursement> pendings = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(url, masterUsername, masterPassword))
		{

			String sql = "SELECT r_id, r_amount, ers_reimbursement_type.rt_type, r_description, r_submitted, u_username, u_firstname, u_lastname, u_email FROM ers_reimbursements INNER JOIN ers_users ON ers_reimbursements.u_id_author = ers_users.u_id INNER JOIN ers_reimbursement_type ON ers_reimbursements.rt_type = ers_reimbursement_type.rt_id WHERE rt_status = 1"; 
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				pendings.add(new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
						rs.getString(8), rs.getString(9)));
			}
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return pendings;
	}

	
	//VIEW ALL REIMBURSEMENT REQUESTS FROM ONE EMPLOYEE
	@Override
	public List<Reimbursement> selectReimbursementsFromEmployee(int empid) {

		List<Reimbursement> reqsOfEmp = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, masterUsername, masterPassword))
		{
			String sql = "SELECT * FROM (SELECT u_id_author, r_amount, ers_reimbursement_type.rt_type, r_description, r_submitted, rs_status FROM ers_reimbursements INNER JOIN ers_reimbursement_type ON ers_reimbursements.rt_type = ers_reimbursement_type.rt_id INNER JOIN ers_reimbursement_status ON ers_reimbursements.rt_status = ers_reimbursement_status.rs_id) WHERE u_id_author = (?) ORDER BY r_submitted";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, empid);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				reqsOfEmp.add(new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
			}
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return reqsOfEmp;
	}
	
	//VIEW ALL RESOLVED REQUESTS AND WHO RESOLVED THEM
	@Override
	public List<Reimbursement> selectAllResolved() {
		List<Reimbursement> resolvedReqs = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, masterUsername, masterPassword))
		{
			String sql = "SELECT r_amount, ers_reimbursement_type.rt_type, r_description, r_submitted, r_resolved, rs_status, u_username, u_firstname, u_lastname \r\n" + 
					"        FROM ers_reimbursements INNER JOIN ers_users ON ers_reimbursements.u_id_resolver = ers_users.u_id \r\n" + 
					"            INNER JOIN ers_reimbursement_type ON ers_reimbursements.rt_type = ers_reimbursement_type.rt_id \r\n" + 
					"                INNER JOIN ers_reimbursement_status ON ers_reimbursements.rt_status = ers_reimbursement_status.rs_id WHERE rt_status > 1 ORDER BY r_resolved"; 
					
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				resolvedReqs.add(new Reimbursement(rs.getDouble(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getString(8), rs.getString(9)));
			}
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return resolvedReqs;
	}
	
	//APPROVE OR DENY REIMBURSEMENT REQUESTS
	@Override
	public void resolveRequest(int reqid, boolean approve, int userid) {
			try(Connection conn = DriverManager.getConnection(url, masterUsername, masterPassword))
			{
				String sql = "call resolveRequest (?,?,?)";
				
				CallableStatement cs = conn.prepareCall(sql);
				if(approve) {
					cs.setInt(2, 3);
					}
				else {
					cs.setInt(2, 2);
				}
				cs.setInt(1, reqid);
				cs.setInt(3, userid);
				
				cs.executeUpdate();
			
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}

}
