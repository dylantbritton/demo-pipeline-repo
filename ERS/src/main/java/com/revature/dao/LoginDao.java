package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.model.User;

public class LoginDao extends MasterDao{
	
	public User login(User user) {
		
		User dbUser = null;

		try(Connection conn = DriverManager.getConnection(url, masterUsername, masterPassword);)
		{
			String sql = "SELECT u_id, u_firstname, u_lastname, u_username, u_password, u_email, ur_role FROM ers_users INNER JOIN ers_user_roles ON ers_users.ur_id = ers_user_roles.ur_id WHERE u_username = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, user.username);
			
			//executing statement
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				dbUser = new User(rs.getInt("u_id"), rs.getString("u_firstname"), rs.getString("u_lastname"), rs.getString("u_username"), rs.getString("u_password"), rs.getString("u_email"), rs.getString("ur_role"));
			}
		}
			catch(SQLException e) {
			e.printStackTrace();
		}
		
		return dbUser;
	}
}
