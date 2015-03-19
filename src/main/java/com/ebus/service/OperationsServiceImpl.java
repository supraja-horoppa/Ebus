package com.ebus.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.ebus.dao.OperationsDao;
import com.ebus.entity.Operations;

public class OperationsServiceImpl implements OperationsService{
	
	@Autowired
	OperationsDao operationsDao;
	
	public List<Operations> getOperations() {
		List<Operations> opts = operationsDao.readOperations();
		return opts;
	}

}
