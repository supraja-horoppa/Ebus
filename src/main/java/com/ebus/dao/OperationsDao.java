package com.ebus.dao;

import java.util.List;
import com.ebus.entity.Operations;

public interface OperationsDao {
	
	public List<Operations> readOperations(String sidx, String sord);
	
}
