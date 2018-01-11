package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.daointerface.EmployeeReimbursementContract;
import com.revature.model.Reimbursement;

public class EmployeeReimbursementDao extends MasterDao implements EmployeeReimbursementContract{

	//SUBMIT NEW REIMBUSREMENT REQUEST - EMPLOYEE
		@Override
		public void submitNewRequest(double amount, String description, int authorid, int type) {

			try(Connection conn = DriverManager.getConnection(url, masterUsername, masterPassword))
			{
				String sql = "call submitRequest(?,?,?,?)";
				CallableStatement cs = conn.prepareCall(sql);
				
				cs.setDouble(1, amount);
				cs.setString(2, description);
				cs.setInt(3, authorid);
				cs.setInt(4, type);
				
				cs.executeQuery();
				
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		//VIEW RESOLVED REIMBURSEMENT REQUESTS FROM ONE EMPLOYEE
		@Override
		public List<Reimbursement> selectResolvedFromEmployee(int empid) {

			List<Reimbursement> reqsOfEmp = new ArrayList<>();
			try(Connection conn = DriverManager.getConnection(url, masterUsername, masterPassword))
			{
				String sql = "SELECT u_id_author, r_amount, ers_reimbursement_type.rt_type, r_description, r_submitted, r_resolved, rs_status, u_username, u_firstname, u_lastname \r\n" + 
						"        FROM ers_reimbursements INNER JOIN ers_users ON ers_reimbursements.u_id_resolver = ers_users.u_id \r\n" + 
						"            INNER JOIN ers_reimbursement_type ON ers_reimbursements.rt_type = ers_reimbursement_type.rt_id \r\n" + 
						"                INNER JOIN ers_reimbursement_status ON ers_reimbursements.rt_status = ers_reimbursement_status.rs_id\r\n" + 
						"                WHERE u_id_author = ? AND rs_status = 'Approved' OR u_id_author = ? AND rs_status = 'Denied' ORDER BY r_resolved";
				
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setInt(1, empid);
				ps.setInt(2, empid);
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next())
				{
					reqsOfEmp.add(new Reimbursement(rs.getDouble(2), rs.getString(3), rs.getString(4), 
									rs.getString(5), rs.getString(6), rs.getString(7),rs.getString(8), 
									rs.getString(9), rs.getString(10)));
				}
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			return reqsOfEmp;
		}
		
		//VIEW PENDING REIMBURSEMENT REQUESTS FROM ONE EMPLOYEE
			@Override
			public ArrayList<Reimbursement> selectPendingFromEmployee(int empid) {

				ArrayList<Reimbursement> reqsOfEmp = new ArrayList<>();
				try(Connection conn = DriverManager.getConnection(url, masterUsername, masterPassword)){
					String sql = "SELECT u_id_author, r_amount, ers_reimbursement_type.rt_type, r_description, r_submitted, ers_reimbursements.rt_status FROM ers_reimbursements \r\n" + 
							"                                    FULL JOIN ers_users ON ers_reimbursements.u_id_resolver = ers_users.u_id \r\n" + 
							"							           FULL JOIN ers_reimbursement_type ON ers_reimbursements.rt_type = ers_reimbursement_type.rt_id\r\n" + 
							"							               WHERE u_id_author = ? AND rt_status = 1 ORDER BY r_submitted";
					PreparedStatement ps = conn.prepareStatement(sql);
					
					ps.setInt(1, empid);
					
					ResultSet rs = ps.executeQuery();
					
					while(rs.next())
					{
						reqsOfEmp.add(new Reimbursement(rs.getDouble(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
					}
					
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
				return reqsOfEmp;
			}
}
