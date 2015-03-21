package com.ebus.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ebus.dao.RoleOperationDao;
import com.ebus.entity.RoleOperation;

public class RoleOperationServiceImpl implements RoleOperationService {
	@Autowired
	RoleOperationDao roleOperationDao;
	public void setRoleOperationDao(RoleOperationDao roleOperationDao) {
        this.roleOperationDao = roleOperationDao;
    }
	public RoleOperation createRoleOperation(RoleOperation roleOperation) {
		return roleOperationDao.createRoleOperation(roleOperation);
	}

}
