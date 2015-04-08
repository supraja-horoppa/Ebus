package com.ebus.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.ebus.dao.RoleDao;
import com.ebus.entity.CustomResponse;
import com.ebus.entity.Role;
import com.ebus.entity.TableModel;

public class RoleServiceImpl implements RoleService {
	
	@Autowired
	RoleDao roleDao;
	 
    public void setRoleDAO(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

	public Role getRoleById(String roleId) {
		return roleDao.readRoleById(roleId);
	}

	public CustomResponse getRoles(int page, int rows, String sidx, String sord) {
		List<Role> roles = roleDao.readRoles(sidx, sord);
		int totalRecords = roles.size();
		TableModel tableModel = new TableModel(page,rows,totalRecords);
		List<Role> roleRecords = new ArrayList<Role>();
        for(int i=tableModel.getFromIndex(); i< tableModel.getToIndex(); i++) {
        	roleRecords.add(roles.get(i));
        	
        }
		
		CustomResponse response = new CustomResponse();
    	response.setRows(roleRecords);
    	response.setRecords( String.valueOf(totalRecords));
    	response.setPage(String.valueOf(page));
    	response.setTotal(String.valueOf(tableModel.getPagesAmount()) );
    	return response;
	}

	public Role createRole(Role role) {
		role.setRoleId(UUID.randomUUID().toString());	
		return roleDao.createRole(role);
	}

	public boolean deleteRole(String roleId) {
		return roleDao.deleteRole(roleId);
	}

	public Role updateRole(String roleId, Role role) {
		return roleDao.updateRole(roleId, role);
	}

	public List<Role> getRoles() {
		return roleDao.readRoles();
	}

    
}
