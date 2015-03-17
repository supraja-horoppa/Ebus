package com.ebus.service;

import java.util.List;

import com.ebus.entity.LoginForm;

public interface LoginService {
	
	public LoginForm getLoginByUsername(String username);
	
	public List<LoginForm> getUsers();

}
