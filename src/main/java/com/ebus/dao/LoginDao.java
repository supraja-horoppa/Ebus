package com.ebus.dao;

import java.util.List;

import com.ebus.entity.LoginForm;

public interface LoginDao {
	
	public LoginForm readLoginByUsername(String username);
	
	public LoginForm readLoginById(String userId);
	
	public List<LoginForm> readUsers();
	
	public LoginForm createUser(LoginForm user);
	
	public boolean deleteUser(String userId);
	
	public LoginForm updateUser(String userId,LoginForm user);

}
