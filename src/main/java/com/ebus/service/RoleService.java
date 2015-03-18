package com.ebus.service;

import java.util.List;
import com.ebus.entity.Role;

public interface RoleService {

	public Role getRoleById(String roleId);
	
	public List<Role> getRoles();
	
	public Role createRole(Role role);
	
	public boolean deleteRole(String roleId);
	
	public Role updateRole(String roleId, Role role);
    
}
