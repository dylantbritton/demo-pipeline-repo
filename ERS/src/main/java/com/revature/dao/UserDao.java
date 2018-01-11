package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.daointerface.UserContract;
import com.revature.model.User;

public class UserDao extends MasterDao implements UserContract {

	public UserDao() {
	}

	//VIEW ALL EMPLOYEES - MANAGER
	@Override
	public List<User> selectAllUser() {
		
		List<User> users = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, masterUsername, masterPassword))
		{
			String sql = "SELECT u_id, u_firstname, u_lastname, u_username, u_email, ur_role FROM ers_users INNER JOIN ers_user_roles ON ers_users.ur_id = ers_user_roles.ur_id ORDER BY u_id";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
			}
			
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return users;
	}
	
	
	//UPDATE USER INFORMATION - EMPLOYEE
	@Override
	public void updateUser(User user, String command, String newInfo) {
		
//		try(Connection conn = DriverManager.getConnection(url, masterUsername, masterPassword))
//		{
//			String sql = "UPDATE ers_users SET u_password = ?, u_email = ? WHERE u_id = ?";
//			
//			PreparedStatement ps = conn.prepareStatement(sql);
//			if(command.equals("email")) {
//				ps.setString(1, user.password);
//				ps.setString(2, newInfo);}
//			else if(command.equals("password")) {
//				ps.setString(1, newInfo);
//				ps.setString(2,user.email);
//			}
//			ps.setInt(3, user.userid);
//			
//			ps.executeUpdate();
//			
//		
//		}catch(SQLException e)
//		{
//			e.printStackTrace();
//		}
	}
}
