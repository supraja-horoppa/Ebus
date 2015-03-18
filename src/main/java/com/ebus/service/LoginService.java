package com.ebus.service;

import java.util.List;

import com.ebus.entity.LoginForm;

public interface LoginService {
	
	public LoginForm getLoginByUsername(String username);
	
	public LoginForm getLoginById(String userId);
	
	public List<LoginForm> getUsers();
	
	public LoginForm createUser(LoginForm user);
	
	public boolean deleteUser(String userId);
	
	public LoginForm updateUser(String userId, LoginForm user);

}
