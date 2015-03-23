package com.ebus.service;

import java.util.List;

import com.ebus.entity.CustomResponse;
import com.ebus.entity.Role;

public interface RoleService {

	public Role getRoleById(String roleId);
	
	public CustomResponse getRoles(int page, int rows, String sidx, String sord);
	
	public Role createRole(Role role);
	
	public boolean deleteRole(String roleId);
	
	public Role updateRole(String roleId, Role role);
	
	public List<Role> getRoles();
    
}
