package com.ebus.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.ebus.dao.OperationsDao;
import com.ebus.entity.CustomResponse;
import com.ebus.entity.Operations;
import com.ebus.entity.TableModel;

public class OperationsServiceImpl implements OperationsService{
	
	@Autowired
	OperationsDao operationsDao;
	
	public CustomResponse getOperations(int page, int rows, String sidx, String sord) {
		List<Operations> opts = operationsDao.readOperations(sidx, sord);
		int totalRecords = opts.size();
		TableModel tableModel = new TableModel(page,rows,totalRecords);
		List<Operations> records = new ArrayList<Operations>();
        for(int i=tableModel.getFromIndex(); i< tableModel.getToIndex(); i++) {
        	records.add(opts.get(i));
        }
		
		CustomResponse response = new CustomResponse();
    	response.setRows(records);
    	response.setRecords( String.valueOf(totalRecords));
    	response.setPage(String.valueOf(page));
    	response.setTotal(String.valueOf(tableModel.getPagesAmount()) );
    	return response;
	}
	
	public CustomResponse getOperationsByRoleId(String roleId, int page, int rows, String sidx, String sord) {
		List<Operations> opts = operationsDao.readOperationsByRoleId(roleId, sidx, sord);
		int totalRecords = opts.size();
		TableModel tableModel = new TableModel(page,rows,totalRecords);
		List<Operations> records = new ArrayList<Operations>();
        for(int i=tableModel.getFromIndex(); i< tableModel.getToIndex(); i++) {
        	records.add(opts.get(i));
        }
		
		CustomResponse response = new CustomResponse();
    	response.setRows(records);
    	response.setRecords( String.valueOf(totalRecords));
    	response.setPage(String.valueOf(page));
    	response.setTotal(String.valueOf(tableModel.getPagesAmount()) );
    	return response;
	}

}
