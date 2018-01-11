package com.revature.service;

import com.revature.dao.LoginDao;
import com.revature.model.User;

public class LoginService {
	public User validateUser(User clientUser) {

		LoginDao dao = new LoginDao();

		User dbUser = dao.login(clientUser);

		if (dbUser != null) {
			if (dbUser.getUsername().equals(clientUser.getUsername()) && dbUser.getPassword().equals(clientUser.getPassword())) {
				dbUser.setPassword(null);
				return dbUser;
			}
		}
		return null;

	}
}
