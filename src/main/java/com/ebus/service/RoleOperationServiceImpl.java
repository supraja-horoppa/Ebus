package com.ebus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ebus.dao.RoleOperationDao;
import com.ebus.entity.RoleOperation;

public class RoleOperationServiceImpl implements RoleOperationService {
	@Autowired
	RoleOperationDao roleOperationDao;
	public void setRoleOperationDao(RoleOperationDao roleOperationDao) {
        this.roleOperationDao = roleOperationDao;
    }
	public List<RoleOperation> createRoleOperation(List<RoleOperation> roleOperation) {
		return roleOperationDao.createRoleOperation(roleOperation);
	}

}
