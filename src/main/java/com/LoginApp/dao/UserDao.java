package com.LoginApp.dao;

import com.LoginApp.model.User;

public interface UserDao {

	boolean checkUserCredentials(User user);

	boolean createUser(User user);

	User getUser(String username);

	boolean updateUser(User user);

}
