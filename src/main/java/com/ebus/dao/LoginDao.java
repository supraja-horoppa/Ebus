package com.ebus.dao;

import java.util.List;

import com.ebus.entity.LoginForm;

public interface LoginDao {
	
	public LoginForm readLoginByUsername(String username);
	
	public List<LoginForm> readUsers();

}
