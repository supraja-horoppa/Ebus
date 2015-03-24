package com.ebus.service;

import java.util.List;

import com.ebus.entity.CustomResponse;
import com.ebus.entity.Operations;

public interface OperationsService {
	
	public CustomResponse getOperations(int page, int rows, String sidx,
			String sord);;
}
