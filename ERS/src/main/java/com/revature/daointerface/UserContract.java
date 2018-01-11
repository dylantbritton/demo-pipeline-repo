package com.revature.daointerface;

import java.util.List;

import com.revature.model.User;


public interface UserContract{
	public List<User> selectAllUser();
	public void updateUser(User user, String command, String newInfo);
}
