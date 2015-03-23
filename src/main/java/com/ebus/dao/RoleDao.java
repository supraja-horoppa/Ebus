package com.ebus.dao;

import java.util.List;
import com.ebus.entity.Role;

public interface RoleDao {
	
    public Role readRoleById(String userId);
	
	public List<Role> readRoles(String sidx, String sord);
	
	public Role createRole(Role role);
	
	public boolean deleteRole(String roleId);
	
	public Role updateRole(String roleId,Role role);
	
	public List<Role> readRoles();

}
