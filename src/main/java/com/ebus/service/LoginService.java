package com.ebus.service;

import com.ebus.entity.CustomResponse;
import com.ebus.entity.LoginForm;

public interface LoginService {
	
	public LoginForm getLoginByUsername(String username);
	
	public LoginForm getLoginById(String userId);
	
	public CustomResponse getUsers(int page, int rows, String sidx, String sord);
	
	public LoginForm createUser(LoginForm user);
	
	public boolean deleteUser(String userId);
	
	public LoginForm updateUser(String userId, LoginForm user);

}
