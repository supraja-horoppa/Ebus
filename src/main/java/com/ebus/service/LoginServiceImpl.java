package com.ebus.service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebus.dao.LoginDao;
import com.ebus.entity.LoginForm;
import com.ebus.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao loginDao;
	 
    public void setLoginDAO(LoginDao loginDao) {
        this.loginDao = loginDao;
    }
    
    
    @Transactional
	public LoginForm getLoginByUsername(String username) {
		 return this.loginDao.readLoginByUsername(username);
	}


	public List<LoginForm> getUsers() {
		List<LoginForm> users = loginDao.readUsers();
		return users;
	}


	public LoginForm createUser(LoginForm user) {
		user.setId(UUID.randomUUID().toString());
		return loginDao.createUser(user);
	}


	public boolean deleteUser(String userId) {
		return loginDao.deleteUser(userId);
	}


	public LoginForm updateUser(String userId, LoginForm user) {
		return loginDao.updateUser(userId,user);
	}


	public LoginForm getLoginById(String userId) {
		return loginDao.readLoginById(userId);
	}

}
