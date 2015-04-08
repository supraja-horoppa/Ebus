package com.ebus.service;

import com.ebus.entity.CustomResponse;


public interface OperationsService {
	
	public CustomResponse getOperations(int page, int rows, String sidx,
			String sord);
	
	public CustomResponse getOperationsByRoleId(String roleId, int page, int rows, String sidx,
			String sord);
}
