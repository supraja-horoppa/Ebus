package com.ebus.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebus.dao.LoginDao;
import com.ebus.entity.CustomResponse;
import com.ebus.entity.DailyAuditReport;
import com.ebus.entity.LoginForm;
import com.ebus.entity.Role;
import com.ebus.entity.TableModel;
import com.ebus.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao loginDao;
	
	@Autowired
	RoleService roleService;
	
    public void setLoginDAO(LoginDao loginDao) {
        this.loginDao = loginDao;
    }
    
    
    @Transactional
	public LoginForm getLoginByUsername(String username) {
		 return this.loginDao.readLoginByUsername(username);
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


	public CustomResponse getUsers(int page, int rows, String sidx, String sord) {
		List<LoginForm> users = loginDao.readUsers(sidx, sord);
		List<LoginForm> usersList = new ArrayList<LoginForm>();
		for(LoginForm user : users) {
			Role role = roleService.getRoleById(user.getRole());
			user.setRole(role.getRoleName());
			usersList.add(user);
		}
		int totalRecords = usersList.size();
		TableModel tableModel = new TableModel(page,rows,totalRecords);
		List<LoginForm> records = new ArrayList<LoginForm>();
        for(int i=tableModel.getFromIndex(); i< tableModel.getToIndex(); i++) {
        	records.add(usersList.get(i));
        }
		
		CustomResponse response = new CustomResponse();
    	response.setRows(records);
    	response.setRecords( String.valueOf(totalRecords));
    	response.setPage(String.valueOf(page));
    	response.setTotal(String.valueOf(tableModel.getPagesAmount()) );
    	return response;
	}


}
